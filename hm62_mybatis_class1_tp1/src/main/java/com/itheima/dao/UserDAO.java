package com.itheima.dao;

import com.itheima.entity.UserInfo;

import java.util.List;

/**
 * 数据层接口
 */
public interface UserDAO {

    /**
     * 查询所有的方法
     * @return
     * @throws Exception
     */
    public List<UserInfo> findAllUsers()throws Exception;


}
