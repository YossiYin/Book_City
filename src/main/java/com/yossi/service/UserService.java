package com.yossi.service;


import com.yossi.pojo.User;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/22 17:17
 */
public interface UserService {

    /**
     * 注册用户
     *
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录
     *
     * @param user
     * @return 返回null登录失败
     */
    public User login(User user);

    /**
     * 检查 用户名是否可以
     *
     * @param username
     * @return true-存在，false-失败
     */

    public boolean existsUsername(String username);
}
