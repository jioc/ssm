package com.jioc.service;


import com.jioc.dao.UserMapper;
import com.jioc.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends com.jioc.base.BaseService<User> {

    @Autowired
    private UserMapper userMapper;
}
