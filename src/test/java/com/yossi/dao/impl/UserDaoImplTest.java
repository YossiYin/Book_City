package com.yossi.dao.impl;

import com.yossi.pojo.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/22 17:02
 */
class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    void queryUserByUsername() {
        if(userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可以");
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Test
    void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","admin")==null){
            System.out.println("用户名或密码错误，登录失败");
        }else{
            System.out.println("登录成功");
        }
    }

    @Test
    void save() {
        //注意id是自增的
        System.out.println( userDao.save(new User(null,"yossi","123456","yossi@qq.com")));
    }
}