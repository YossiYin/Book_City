package com.yossi.test;

import com.yossi.pojo.Book;
import com.yossi.service.BookService;
import com.yossi.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/28 20:20
 */
public class BookServletTest {
    private BookService bookService= new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"转成成为雷电将军然后天下无敌","八重神子",
                new BigDecimal(9999),1100000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(45,"转成成为雷电将军然后天下无敌","八重神子",
                new BigDecimal(9999),180,0,null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(45));
    }

    @Test
    public void queryBooks() {
        System.out.println(bookService.queryBooks());
    }
}