package com.pojo;

public class Comment {
    private int id;
    private String username;
    private String comment;
    private String commentTime;
    private int commentId;

    public Comment() {
    }

    public Comment(String username, String comment, String commentTime) {
        this.username = username;
        this.comment = comment;
        this.commentTime = commentTime;
    }

    public Comment(int id, String username, String comment, String commentTime, int commentId) {
        this.id = id;
        this.username = username;
        this.comment = comment;
        this.commentTime = commentTime;
        this.commentId = commentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Comment(int id, String username, String comment, String commentTime) {
        this.id = id;
        this.username = username;
        this.comment = comment;
        this.commentTime = commentTime;
    }
}
