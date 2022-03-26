package com.test;

import com.dao.UserDao;
import com.pojo.Issue;
import com.service.IssueService;
import org.junit.Test;

import java.util.List;

public class AllTest {
    private UserDao userDao = new UserDao();
    private IssueService issueService = new IssueService();

//    UserDao的测试
    @Test
    public void UserDaoTest() {
        int flag = userDao.queryExitByUsername("hello");
        if(flag == 1) {
            System.out.println("exit");
        }else {
            System.out.println("no exit");
        }
    }

//    @Test
//    public void UserDao1Test() {
//        userDao.insertUser("test1","test2","2020-11-27");
//    }
//
//    @Test
//    public void IssueServiceTest() {
//        List<Issue> issues = issueService.getIssue();
//        System.out.println(issues.toString());
//    }
}
