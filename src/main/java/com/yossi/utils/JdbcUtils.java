package com.yossi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/5/22 15:44
 */
public class JdbcUtils {

    private static DataSource ds;


    static {
        Properties properties = new Properties();
        try {
//            properties.load(new FileInputStream("src\\main\\java\\druid.properties"));
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
//            ClassLoader.getSystemClassLoader().getResourceAsStream("src\\main\\java\\druid.properties");
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池中的连接
     * @return 返回null，获取连接失败
     */
    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }

    /**
     * 关闭连接的资源
     * @param conn
     */
    public static void close(Connection conn){

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
