package com.yossi.test;

import com.yossi.dao.BookDao;
import com.yossi.dao.impl.BookDaoImpl;
import com.yossi.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/28 17:21
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"转成成为雷电将军然后天下无敌","八重神子",
                                                            new BigDecimal(9999),1100000,0,null));


    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"转成成为雷电将军然后天下无敌","八重神子",
                new BigDecimal(1571),1100000,1,null));


    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
       bookDao.queryBooks();

    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());//正常
    }

    @Test
    public void queryForPageItems() {
        System.out.println(bookDao.queryForPageItems(8,4));//正常
    }


}