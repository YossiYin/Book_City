package com.yossi.service.impl;

import com.yossi.dao.UserDao;
import com.yossi.dao.impl.UserDaoImpl;
import com.yossi.pojo.User;
import com.yossi.service.UserService;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/22 17:20
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.save(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null){
            //没查到表示可用
            return false;
        }else {
            return true;
        }
    }
}
