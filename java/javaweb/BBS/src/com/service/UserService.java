package com.service;

import com.dao.UserDao;

public class UserService {
    private UserDao userDao = new UserDao();

//    判断用户是否存在
    public int queryExit(String username) {
        return userDao.queryExitByUsername(username);
    }

//    注册用户
    public void userRegister(String username,String password,String createTime) {
        userDao.insertUser(username,password,createTime);
    }

//    登录
    public int userLogin(String username,String password) {
        return userDao.queryExitByUsernameAndPassword(username,password);
    }
}
