package com.yossi.dao.impl;

import com.yossi.dao.BookDao;
import com.yossi.pojo.Book;

import java.util.List;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/28 17:02
 */
public class BookDaoImpl extends BasicDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book( `name` , `author` , `price` , `sales` , `stock` , `img_path`) \n" +
                "values(?, ? , ?, ?, ? , ?)";


        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";

        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=? , `sales`=? , `stock`=?,`img_path`=? where id =?";
        return update(sql,book.getName(),book.getAuthor(), book.getPrice(), book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where id = ?";

        return (Book) querySingle(sql,Book.class,id);
    }

//    查询全部图书
    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book";
        return queryMulti(sql,Book.class);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number)queryScalar(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath " +
                "from t_book limit ?,?";
        return queryMulti(sql,Book.class,begin,pageSize);
    }
}
