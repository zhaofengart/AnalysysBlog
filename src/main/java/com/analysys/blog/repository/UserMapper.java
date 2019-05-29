package com.analysys.blog.repository;

import com.analysys.blog.entity.User;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    int updateByPrimaryKey(User record);


    /**
     * 获取包含指定用户名和密码的用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User select(String username, String password);


    /**
     * 根据用户id更新密码
     *
     * @param userId 用户id
     * @param password 密码
     * @return
     */
    Integer updatePassword(Integer userId, String password);


    /**
     * 根据用户名查询用户
     *
     * @param
     * @return 
     */
    User selectUserByUsername(String username);
}