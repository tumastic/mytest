package com.itheima.test;

import com.itheima.dao.impl.UserDAOImpl;
import com.itheima.entity.UserInfo;

import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        try {
            List<UserInfo> userInfos = new UserDAOImpl().findAllUsers();
            for (UserInfo userInfo : userInfos) {
                System.out.println(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
