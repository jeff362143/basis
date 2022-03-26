package com.dao;

import com.pojo.User;

public class UserDao extends BaseDao {

//    根据用户名查询数据库中，是否存在(return 1就是存在，return 0就是不存在)
    public int queryExitByUsername(String username) {
        String sql = "select * from user where username = ?";
        if(queryForOne(User.class,sql,username) != null) {
            return 1;
        }else {
            return -1;
        }
    }

//    插入数据到user表
    public void insertUser(String username,String password,String createTime) {
        String sql = "insert into user values(Default,?,?,?)";
        update(sql,username,password,createTime);
    }

//    根据账号密码判断用户是否存在
    public int queryExitByUsernameAndPassword(String username,String password) {
        String sql = "select * from user where username = ? and password = ?";
        if(queryForOne(User.class,sql,username,password) == null) {
            return -1;
        }else {
            return 1;
        }
    }

}
