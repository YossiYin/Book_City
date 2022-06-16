package com.yossi.test;

import com.yossi.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/22 16:06
 */
public class JdbcUtilsTest {

    /**
     * 测试数据库连接
     * @throws SQLException
     */
    @Test
    public void testJdbcUtils() throws SQLException {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            //记得关闭
            JdbcUtils.close(connection);
        }
    }
}
