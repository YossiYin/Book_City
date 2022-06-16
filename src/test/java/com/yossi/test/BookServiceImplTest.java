package com.yossi.test;

import com.yossi.service.BookService;
import com.yossi.service.impl.BookServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/29 13:57
 */
public class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void page() {
        System.out.println(bookService.page(1,4));
    }
}