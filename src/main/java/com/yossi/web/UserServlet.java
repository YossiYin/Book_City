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
import java.lang.reflect.Method;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/28 14:38
 */
@WebServlet(name = "userServlet", value = "/userServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();



    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //登录
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

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注册
        //1.获取到用户输入的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //2. 检查验证码是否正确（由服务器生成）
        //暂时写死为abcde,记得忽略大小写
        if ("abcde".equalsIgnoreCase(code)) {
            //成功
            //3.检查用户名
            if (userService.existsUsername(username)) {
                //不可用
                System.out.println("用户名已存在，不可用");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                //4.存入数据库
                userService.registerUser(new User(null,username,password,email));
                //跳转成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);

            }
        } else {
            //验证码错误，跳回注册页面
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    }
