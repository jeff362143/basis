package com.test;

import com.dao.imple.MessageDao;
import com.pojo.UserMessage;
import org.junit.Test;
import java.util.List;

public class UserMessageTest {
    private MessageDao messageDao = new MessageDao();

    @Test
    public void Test() {
        List<UserMessage> userMessages = messageDao.queryMessages();
        System.out.println(userMessages);
    }
}
