package com.analysys.blog.controller;

import com.analysys.blog.common.ReturnData;
import com.analysys.blog.entity.User;
import com.analysys.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaofeng
 * @date 2019/5/23
 */

@CrossOrigin
@RestController
@RequestMapping("/blog/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ReturnData login(String username, String password, HttpServletRequest request){
        return userService.login(username, password);
    }

    @PostMapping("/register")
    public ReturnData register(User user){
        return userService.register(user);
    }

    @PostMapping("/updatePassword")
    public ReturnData updatePassword(Integer userId, String oldPassword, String newPassword){
        return userService.updatePassword(userId, oldPassword, newPassword);
    }

}
