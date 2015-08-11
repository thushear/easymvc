package com.kongming.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 说明:
 * User: kongming
 * Date: 2015/5/6
 * Time: 14:53
 */
public class DBUtils {


    public static Connection connectToDefaultDB() {
        return connectDB("kongming", "123456", "jdbc:mysql://192.168.159.127:3306/diamond?useUnicode=true&characterEncoding=UTF-8");
    }


    public static Connection connectDB(String userName, String password, String url) {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url,
                    userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
