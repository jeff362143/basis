package com.pojo;

public class  IssueComments {
    private int issueId;
    private String comment;
    private String time;
    private String author;

    public IssueComments(int issueId, String comment, String time, String author) {
        this.issueId = issueId;
        this.comment = comment;
        this.time = time;
        this.author = author;
    }

    public IssueComments() {

    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int blogId) {
        this.issueId = blogId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "comment{" +
                "issueId=" + issueId +
                ", comment='" + comment + '\'' +
                ", time='" + time + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
