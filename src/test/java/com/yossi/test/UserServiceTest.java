package com.yossi.test;

import com.yossi.pojo.User;
import com.yossi.service.UserService;
import com.yossi.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/22 17:24
 */
class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    void registerUser() {
        userService.registerUser(new User(null,"jack","666","jack@qq.com"));
        userService.registerUser(new User(null,"mike","777","mike@qq.com"));
    }

    @Test
    void login() {
        if(userService.login(new User(null,"jack","666",null))!=null){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    @Test
    void existsUsername() {
        if(userService.existsUsername("666")){
            System.out.println("用户已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}