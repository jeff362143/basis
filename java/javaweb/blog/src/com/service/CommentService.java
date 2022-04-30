package com.service;

import com.dao.imple.CommentDao;
import com.pojo.Comment;

import java.util.List;

public class CommentService {
    private CommentDao commentDao = new CommentDao();

//    根据博客id获取用户对该博客的全部评论
    public List<Comment> GetCommentsById(int id) {
        return commentDao.GetCommentsById(id);
    }

//    保存用户评论到博客评论表中
    public void saveComment(int id,String username,String comment,String commentTime) {
        commentDao.SaveCommentFromUser(id,username,comment,commentTime);
    }

//    获取用户的全部评论
    public List<Comment> getCommentsByUsernameService(String username) {
        return commentDao.getCommentsByUsername(username);
    }

//
    public void deleteCommentService(int commentId) {
        commentDao.deleteCommentById(commentId);
    }
}
