package com.yossi.service.impl;

import com.yossi.dao.BookDao;
import com.yossi.dao.impl.BookDaoImpl;
import com.yossi.pojo.Book;
import com.yossi.pojo.Page;
import com.yossi.service.BookService;

import java.util.List;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/28 20:18
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();


        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页显示数量
        page.setPageSize(pageSize);

        //求总记录数并设置
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount / pageNo;
        if (pageTotalCount % pageSize > 0){
            pageTotal++;//无法整除需要加一页
        }

        /* 数据边界的有效检查 */
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }

        page.setPageTotal(pageTotal);//设置总页面

        //当前页数据
        int begin = (pageNo-1)*pageSize;//公式算出来用于给数据库分页的
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);//设置当前页数据

        return page;
    }
}
