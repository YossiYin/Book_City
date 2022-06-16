package com.yossi.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/28 20:27
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getParameter("action");
        System.out.println("修改了此行");
        System.out.println("master修改了此行，但没有和hotfix冲突");
        System.out.println("master冲突修改此行第三次！！！");
        System.out.println("master增加了此行，但没有和hotfix冲突");


        try {
            //通过反射得到方法
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            //调用方法
            method.invoke(this,req,resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

}
