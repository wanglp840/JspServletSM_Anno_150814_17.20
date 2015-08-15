package com.wanglp.service.login;


import com.wanglp.common.entity.User;

import java.sql.Connection;

/**
 * Created by Administrator on 2015/5/19.
 */
public interface UserService {

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @param connection
     * @return
     */
    public User queryUserById(Integer userId, Connection connection);

    /**
     * 查询该用户是否存在
     * @param userName
     * @param password
     * @return
     */
    public User queryUserByNamePwd(String userName, String password, Connection connection);

    /**
     * 新增用户
     * @param userName
     * @param password
     * @param connection
     */
    public void add(String userName, String password, Connection connection);
}
