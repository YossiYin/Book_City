package com.yossi.dao.impl;

import com.yossi.dao.UserDao;
import com.yossi.pojo.User;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/22 16:46
 */
public class UserDaoImpl extends BasicDao implements UserDao {



    //根据用户名查询单个用户
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";

        return (User) querySingle(sql,User.class,username);
    }

    //根据账号密码查询用户
    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? And password = ?";

        return (User) querySingle(sql,User.class,username,password);

    }

    //保存

    /**
     *
     * @param user 需要保存的用户
     * @return -1 表示失败
     */
    @Override
    public int save(User user) {
        String sql="insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
