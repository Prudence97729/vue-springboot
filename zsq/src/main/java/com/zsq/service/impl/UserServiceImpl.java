package com.zsq.service.impl;

import com.zsq.mapper.UserMapper;
import com.zsq.pojo.User;
import com.zsq.service.UserService;
import com.zsq.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
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
}
