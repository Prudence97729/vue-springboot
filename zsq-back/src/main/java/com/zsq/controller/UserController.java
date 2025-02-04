package com.zsq.controller;

import com.zsq.pojo.Result;
import com.zsq.pojo.User;
import com.zsq.service.UserService;
import com.zsq.utils.JwtUtil;
import com.zsq.utils.Md5Util;
import com.zsq.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.apache.naming.factory.ResourceLinkFactory;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        //查询用户，需要调用service方法，需要添加service对象
        User user = userService.findByUserName(username);
        if (user == null) {
            //用户名没有被占用
            //注册
            userService.register(username, password);
            return Result.success();
        } else {
            //用户名已被占用
            return Result.error("用户名已被占用");
        }
    }
    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password){
       //根据用户名查找用户
        User loginuser = userService.findByUserName(username);
        //判断该用户是否存在
        if(loginuser == null){
            return Result.error("用户名错误");
        }


        //判断密码是否正确 loginUser对象中的密码是加密过的,所以判断的时候要先加密再比对
        if(Md5Util.getMD5String(password).equals(loginuser.getPassword())){
            //登录成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",loginuser.getId());
            claims.put("username", loginuser.getUsername());
            claims.put("password", loginuser.getPassword());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
            //return Result.success("jwt token令牌");
        }
        return Result.error("密码错误");
    }
    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/){
        //根据用户名查找用户信息
//        Map<String, Object> map = JwtUtil.parseToken(token);
//        String username = (String) map.get("username");//已经在拦截器里用ThreadLocal优化了
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String)map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam("avatar") MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return Result.error("请选择要上传的图片");
        }
        
        // 验证文件类型
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            return Result.error("只能上传图片文件");
        }
        
        try {
            String avatarUrl = userService.updateAvatar(file);
            return Result.success(avatarUrl);
        } catch (Exception e) {
            e.printStackTrace(); // 添加日志
            return Result.error("头像上传失败: " + e.getMessage());
        }
    }
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        //1.校验参数validation无法满足这个方法的校验
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要的参数");
        }
        //看原密码是否正确
        //调用userService根据用户名拿到原密码，再与old_pwd比对
        Map<String,Object> map = ThreadLocalUtil.get();
        String username =(String)map.get("username");
        User loginuser = userService.findByUserName(username);
        if(!loginuser.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error("原密码填写不正确");
        }
        //两次填写的密码是否一样
        if(!rePwd.equals(newPwd)){
            return Result.error("两次输入的密码不一致");
        }
        //2.调用service完成密码更新
        Integer id = loginuser.getId();//根据用户名找到的用户信息，调用其方法找到ID
        System.out.println(id);
        userService.updatePwd(newPwd,id);
        return Result.success();
    }
}
