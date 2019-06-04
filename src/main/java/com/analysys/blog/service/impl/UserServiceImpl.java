package com.analysys.blog.service.impl;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.common.RtCode;
import com.analysys.blog.entity.User;
import com.analysys.blog.repository.UserMapper;
import com.analysys.blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhaofeng
 * @date 2019/5/23
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public JsonResult login(String username, String password) {
        User user = userMapper.select(username, password);
        if (user == null) {
            return new JsonResult(RtCode.BadRequest, UserResult.USERNAME_OR_PASSWORD_ERROR.toString());
        }

        return new JsonResult(user);
    }

    @Override
    public JsonResult register(User user) {
        if (user.getUsername() == null || user.getPassword() == null){
            return new JsonResult(RtCode.BadRequest, UserResult.USERNAME_OR_PASSWORD_CAN_NOT_BE_NULL.toString());
        }
        System.out.println("进入注册");

        User userResult = userMapper.selectUserByUsername(user.getUsername());
        if (userResult != null) {
            return new JsonResult(RtCode.BadRequest, UserResult.USERNAME_ALREADY_EXISTS.toString());
        }

        userMapper.insert(user);

        return new JsonResult(user.getUserId());
    }

    @Override
    public JsonResult updatePassword(Integer userId, String oldPassword, String newPassword) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null && user.getPassword().equals(oldPassword)) {
            userMapper.updatePassword(userId, newPassword);
        }

        return new JsonResult();
    }



    enum UserResult {

        REGISTER_FAILURE("注册失败"),
        USERNAME_OR_PASSWORD_CAN_NOT_BE_NULL("用户名或密码不能为空"),
        USERNAME_ALREADY_EXISTS("用户名已存在"),
        USERNAME_OR_PASSWORD_ERROR("登陆失败，用户名、密码信息不正确。"),
        UPDATE_FAILURE("更新失败");

        private String userResult;

        UserResult(String userResult){
            this.userResult = userResult;
        }

        @Override
        public String toString() {
            return userResult;
        }
    }
}
