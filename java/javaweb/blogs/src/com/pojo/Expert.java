package com.pojo;

public class Expert {
    private int userId;
    private String username;
    private String admindesc;
    private int blogCount;

    public Expert() {
    }

    public Expert(int userId, String username, String admindesc, int blogCount) {
        this.userId = userId;
        this.username = username;
        this.admindesc = admindesc;
        this.blogCount = blogCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getadmindesc() {
        return admindesc;
    }

    public void setadmindesc(String admindesc) {
        this.admindesc = admindesc;
    }

    public int getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(int blogCount) {
        this.blogCount = blogCount;
    }

    @Override
    public String toString() {
        return "Expert{" +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", admindesc='" + admindesc + '\'' +
                ", blogCount=" + blogCount +
                '}';
    }
}
