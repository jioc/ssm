package com.shsxt.controller;

import com.shsxt.po.User;
import com.shsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "getUser2/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser2(@PathVariable Integer id) throws Exception {
        return userService.queryById(id);
    }
    @RequestMapping("getUser3/{id}/{name}")
    @ResponseBody
    public User getUser3(@PathVariable Integer id, @PathVariable String name) throws Exception {
        System.out.println("id: "+id + " - name: "+name);
        return userService.queryById(id);
    }

    @RequestMapping("delUser")
    @ResponseBody
    public Integer delUser(Integer id) throws Exception {
        return userService.delete(id);
    }

}
