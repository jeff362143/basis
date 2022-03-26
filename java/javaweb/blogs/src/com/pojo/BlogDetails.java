package com.pojo;

import java.util.Arrays;
import java.util.List;

public class BlogDetails {
    private int id;
    private String title;
    private String content;
    private String createTime;
    private String author;
    private List comments;
    private int likedCount;
    private int collCount;


    public BlogDetails() {
    }

    public BlogDetails(int id, String title, String content, String createTime, String author,  List comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.author = author;
        this.comments = comments;
    }

    public BlogDetails(int id, String title, String content, String createTime, String author, List comments, int likedCount, int collCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.author = author;
        this.comments = comments;
        this.likedCount = likedCount;
        this.collCount = collCount;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(int likedCount) {
        this.likedCount = likedCount;
    }

    public int getCollCount() {
        return collCount;
    }

    public void setCollCount(int collCount) {
        this.collCount = collCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public List getComments() {
        return comments;
    }

    public void setComments(List comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "BlogDetails{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", author='" + author + '\'' +
                ", comments=" + comments +
                ", likedCount=" + likedCount +
                ", collCount=" + collCount +
                '}';
    }
}
