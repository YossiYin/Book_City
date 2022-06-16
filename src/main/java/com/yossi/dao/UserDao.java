package com.yossi.dao;

import com.yossi.pojo.User;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/22 16:40
 */
public interface UserDao {
    /**
     *
     * @param username 用户名
     * @return 返回null表示无此用户
     */
    public User queryUserByUsername(String username);

    /**
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回null表示无此用户/密码错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     *
     * @param user 需要保存的用户
     * @return 返回-1表示失败
     */
    public int save(User user);
}
