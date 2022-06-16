package com.yossi.web;

import com.alibaba.druid.support.http.stat.WebAppStatUtils;
import com.yossi.pojo.Book;
import com.yossi.pojo.Page;
import com.yossi.service.BookService;
import com.yossi.service.impl.BookServiceImpl;
import com.yossi.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/28 20:30
 */
@WebServlet(name = "bookServlet" ,value = "/manager/bookServlet")
public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取，封装
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //调用service方法添加
        bookService.addBook(book);
        //跳转
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        //使用重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");



    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的id
        String id= req.getParameter("id");
        //2.调用Service方法删除
        int i = Integer.parseInt(id);
        bookService.deleteBookById(i);
        //3.重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
        System.out.println(req.getContextPath());
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数并封装
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //调用Service修改
        bookService.updateBook(book);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");


    }

    //列出所有图书
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过service查询全部图书
        List<Book> books = bookService.queryBooks();
        //保存全部图书到Request域中
        req.setAttribute("books",books);
        //请求转发到book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);


    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的图书编号
        int id = Integer.parseInt(req.getParameter("id"));
        //查询图书
        Book book = bookService.queryBookById(id);
        //保存到Request域中
        req.setAttribute("book",book);
        //转发
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    /**
     *处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取请求的参数,默认第一页
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
            //没有传就用默认值
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用service
        Page<Book> page = bookService.page(pageNo, pageSize);
        //3.保存page到request域中
        req.setAttribute("page",page);
        //4.请求转发
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }


    }
