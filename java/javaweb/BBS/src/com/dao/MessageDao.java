package com.dao;

import com.pojo.UserMessage;

import java.util.List;

public class MessageDao extends BaseDao {
    public void saveMessage(String user,String message,String time) {
        String sql = "insert into message values(Default,?,?,?)";
        update(sql,user,message,time);
    }

    public List<UserMessage> getUserMessage() {
        String sql = "select * from message order by time desc";
        return queryForList(UserMessage.class,sql);
    }
}
