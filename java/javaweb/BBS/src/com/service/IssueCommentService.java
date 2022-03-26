package com.service;

import com.dao.IssueCommentDao;
import com.pojo.IssueComments;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class IssueCommentService  {
    private IssueCommentDao issueCommentDao = new IssueCommentDao();

    public void insertIntoIssueService(IssueComments issueComments) throws UnsupportedEncodingException {
        issueCommentDao.insertIntoIssue(issueComments);
    }

    public List<IssueComments> getIssueCommentService(int id) {
        return issueCommentDao.getIssueComment(id);
    }
}
