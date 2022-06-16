package com.yossi.dao;

import com.yossi.pojo.Book;

import java.util.List;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/28 16:58
 */
public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);
}
