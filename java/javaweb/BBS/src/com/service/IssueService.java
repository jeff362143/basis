package com.service;

import com.dao.IssueDao;
import com.pojo.Issue;
import com.pojo.IssueList;

import java.util.List;

public class IssueService {
    private IssueDao issueDao = new IssueDao();

    public List<Issue> getIssue(String sort) {
        return issueDao.QueryIssue(sort);
    }

    public void insertIntoIssueService(Issue issue) {
        issueDao.insertIntoIssue(issue);
    }

    public List<IssueList> getIssueListService() {
        return issueDao.getIssueList();
    }

    public Issue getIssueByIdService(int id) {
        return issueDao.getIssueById(id);
    }

    public List<Issue> getAllIssueService() {
        return issueDao.getAllIssue();
    }

    public void addLabelService(String label) {
        issueDao.addLabel(label);
    }

    public void deleteLabelService(String labelName) {
        issueDao.deleteLabel(labelName);
    }

    public void recoIssueService(int id) {
        issueDao.recoIssue(id);
    }
}
