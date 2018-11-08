package com.shsxt.controller;

import com.shsxt.po.User;
import com.shsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xlf on 2018/11/8.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(Integer id) throws Exception {
        return userService.queryById(id);
    }

    @RequestMapping("delUser")
    @ResponseBody
    public Integer delUser(Integer id) throws Exception {
        return userService.delete(id);
    }
}
