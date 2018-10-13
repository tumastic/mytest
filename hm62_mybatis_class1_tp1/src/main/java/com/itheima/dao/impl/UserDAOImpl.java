package com.itheima.dao.impl;

import com.itheima.dao.UserDAO;
import com.itheima.entity.UserInfo;
import com.itheima.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    // 相当于你之前的jdbctemplate这个对象
    private QueryRunner qr = new QueryRunner();

    public List<UserInfo> findAllUsers() throws Exception {

        // 第一个参数需要你绑定一个connection
        String sql = "select * from user";
        Connection conn = JdbcUtils.getConn();
        return qr.query(conn,sql,new BeanListHandler<UserInfo>(UserInfo.class));
    }
}
