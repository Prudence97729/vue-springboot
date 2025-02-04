package com.zsq.service.impl;

import com.zsq.mapper.UserMapper;
import com.zsq.pojo.User;
import com.zsq.service.UserService;
import com.zsq.utils.Md5Util;
import com.zsq.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Value("${user.dir}")
    private String userDir;

    @Override
    public User findByUserName(String username) {//调用mapper里面的方法，访问数据库
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        //加密
        String md5string = Md5Util.getMD5String(password);
        //在数据库中添加
        userMapper.add(username,md5string);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public String updateAvatar(MultipartFile file) {
        try {
            // 生成文件名
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                throw new RuntimeException("文件名不能为空");
            }
            
            // 确保是图片文件
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                throw new RuntimeException("只能上传图片文件");
            }
            
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + suffix;
            
            // 构建文件路径
            String basePath = System.getProperty("user.dir");
            String uploadDir = basePath + "/upload/avatar";
            String filePath = uploadDir + "/" + fileName;
            
            // 创建目录
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            // 保存文件
            File destFile = new File(filePath);
            file.transferTo(destFile);
            
            // 添加更详细的日志
            System.out.println("项目根目录：" + System.getProperty("user.dir"));
            System.out.println("文件完整路径：" + destFile.getAbsolutePath());
            System.out.println("文件是否存在：" + destFile.exists());
            System.out.println("文件是否可读：" + destFile.canRead());
            
            // 返回URL
            String avatarUrl = "/upload/avatar/" + fileName;
            
            // 更新数据库
            Map<String, Object> map = ThreadLocalUtil.get();
            Integer userId = (Integer) map.get("id");
            userMapper.updateAvatar(avatarUrl, userId);
            
            return avatarUrl;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传失败: " + e.getMessage());
        }
    }

    @Override
    public void updatePwd(String newPwd,Integer id) {
        userMapper.updatePwd(Md5Util.getMD5String(newPwd),id);//注意这里要加密再写入数据库
    }
}
