package com.analysys.blog.service;

import com.analysys.blog.common.ReturnData;
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
    ReturnData login(String username, String password);


    /**
     * 注册
     *
     * @param
     * @return 
     */
    ReturnData register(User user);


    /**
     * 更新密码
     *
     * @param
     * @return 
     */
    ReturnData updatePassword(Integer userId, String oldPassword, String newPassword);
}
