package com.dao;

import com.pojo.Issue;
import com.pojo.IssueList;

import java.util.ArrayList;
import java.util.List;

public class IssueDao extends BaseDao {

    public List<IssueList> getIssueList() {
        String sql = "select * from issueList";
        return queryForList(IssueList.class,sql);
    }

    public List<Issue> QueryIssue(String sort) {
        if(sort.equals("热门")) {
            String sql = "select * from issue where reco = 1 order by time desc";
            return queryForList(Issue.class,sql);
        }
        String sql2 = "select * from issue where marked = ? order by time desc";
        return queryForList(Issue.class,sql2,sort);
    }

    public void insertIntoIssue(Issue issue) {
        String sql = "insert into issue values(Default,?,?,?,?,?,?)";
        update(sql,issue.getAuthor(),issue.getTitle(),issue.getContent(), issue.getTime(),issue.getMarked(),0);
    }

    public Issue getIssueById( int id) {
        String sql = "select * from issue where id = ?";
        return queryForOne(Issue.class,sql,id);
    }

    public List<Issue> getAllIssue() {
        String sql ="select * from issue order by time desc";
        return queryForList(Issue.class,sql);
    }

    public void addLabel(String labelName) {
        String sql = "insert into issueList values(Default,?)";
        update(sql,labelName);
    }

    public void deleteLabel(String labelName) {
        String sql = "delete  from issueList where name = ?";
        update(sql,labelName);
        String sql2 = "ALTER TABLE issueList DROP id";
        update(sql2);
        String sql3 = "ALTER TABLE issueList ADD id int NOT NULL FIRST";
        update(sql3);
        String sql4 = "ALTER TABLE issueList MODIFY COLUMN id int NOT NULL AUTO_INCREMENT,ADD PRIMARY KEY(id)";
        update(sql4);
        String sql5 = "select count(*) from issueList";
        Object o = queryForSingleValue(sql5);
        int count = Integer.parseInt(o.toString());
        String sql6 = "ALTER TABLE issueList AUTO_INCREMENT = ?";
        update(sql6,count+1);
    }

    public void recoIssue(int id) {
        String sql = "select reco from issue where id = ?";
        String sql2 = "update issue set reco = 1 where id = ?";
        String sql3 = "update issue set reco = 0 where id = ?";
        Object o = queryForSingleValue(sql, id);
        int flag = Integer.parseInt(o.toString());
        if(flag == 1) {
            update(sql3,id);
        }else {
            update(sql2,id);
        }
    }

}
