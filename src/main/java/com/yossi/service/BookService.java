package com.yossi.service;

import com.yossi.pojo.Book;
import com.yossi.pojo.Page;

import java.util.List;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/28 20:16
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(int pageNo, int pageSize);




}
