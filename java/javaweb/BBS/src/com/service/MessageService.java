package com.service;

import com.dao.MessageDao;
import com.pojo.UserMessage;

import java.util.List;

public class MessageService {
    private MessageDao messageDao = new MessageDao();

    public void saveMessageService(String user,String message,String time) {
        messageDao.saveMessage(user,message,time);
    }

    public List<UserMessage> getUserMessageService() {
        return  messageDao.getUserMessage();
    }
}
