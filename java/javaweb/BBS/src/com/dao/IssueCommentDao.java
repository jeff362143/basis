package com.dao;

import com.pojo.IssueComments;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class IssueCommentDao extends BaseDao {
    public void insertIntoIssue(IssueComments issueComments) throws UnsupportedEncodingException {
        String sql = "insert into comment values(DEFAULT,?,?,?,?)";
        String comment = java.net.URLDecoder.decode(issueComments.getComment(),"UTF-8");
            update(sql, issueComments.getIssueId(),comment, issueComments.getTime(), issueComments.getAuthor());
        }

        public List<IssueComments> getIssueComment(int id) {
            String sql = "select * from comment where issueId = ?";
            return queryForList(IssueComments.class,sql,id);
        }
}
