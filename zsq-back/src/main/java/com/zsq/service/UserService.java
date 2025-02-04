package com.zsq.service;

import com.zsq.pojo.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    //根据用户名查询用户
    User findByUserName(String username);

    //注册
    void register(String username, String password);

    //更新用户的基本信息
    void update(User user);

    //更新头像
    String updateAvatar(MultipartFile file);

    //更新用户密码
    void updatePwd(String newPwd,Integer id);
}
