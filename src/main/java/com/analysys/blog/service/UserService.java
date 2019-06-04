package com.analysys.blog.service;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.entity.User;

/**
 * @author zhaofeng
 * @date 2019/5/23
 */

public interface UserService {

    /**
     * 登录
     *
     * @param
     * @return
     */
    JsonResult login(String username, String password);


    /**
     * 注册
     *
     * @param
     * @return
     */
    JsonResult register(User user);


    /**
     * 更新密码
     *
     * @param
     * @return
     */
    JsonResult updatePassword(Integer userId, String oldPassword, String newPassword);


}
