package com.service;

import com.dao.imple.MessageDao;
import com.pojo.UserMessage;

import java.util.List;

public class MessageService {
    private MessageDao messageDao = new MessageDao();

//   上传留言(额，写错位置了)
    public void Update(String table,Object ...args) {
        String sql = "insert into " + table + " values(?,?,?,null)";
        messageDao.update(sql,args);
    }

//    获取留言(按时间降序)
    public List<UserMessage> userMessages() {
        return messageDao.queryMessages();
    }
//    获取指定时期留言
    public List<UserMessage> userMessagesByScope(String scope1,String scope2) {
        return messageDao.queryMessagesByScope(scope1,scope2);
    }


}
