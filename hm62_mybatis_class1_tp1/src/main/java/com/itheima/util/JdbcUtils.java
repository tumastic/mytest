package com.itheima.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

    // 定义四大属性
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/mybatisdb?characterEncoding=UTF-8";
    private static final String username = "root";
    private static final String password = "root";


    public static Connection getConn(){
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(getConn());
    }



}
