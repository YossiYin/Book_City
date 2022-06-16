package com.yossi.web;

import com.yossi.pojo.User;
import com.yossi.service.UserService;
import com.yossi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/22 20:00
 * 此类作废
 */
@WebServlet(name = "LoginServlet",value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    //得到一个Service类
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.login(new User(null,username,password,null)) != null){
            //登录成功
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);

        }else {
            //登录失败
            System.out.println("登录失败");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }

    }
}
