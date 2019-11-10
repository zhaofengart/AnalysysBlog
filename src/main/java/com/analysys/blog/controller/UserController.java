package com.analysys.blog.controller;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.entity.User;
import com.analysys.blog.service.UserService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaofeng
 * @date 2019/5/23
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/blog/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public JsonResult login(@ApiParam("用户名") String username, @ApiParam("密码") String password){
        log.info(username+password);
        return userService.login(username, password);
    }

    @PostMapping("/register")
    public JsonResult register(User user){
        return userService.register(user);
    }

    @PostMapping("/updatePassword")
    public JsonResult updatePassword(@ApiParam("用户id") Integer userId, @ApiParam("旧密码") String oldPassword, @ApiParam("新密码") String newPassword){
        return userService.updatePassword(userId, oldPassword, newPassword);
    }

}
