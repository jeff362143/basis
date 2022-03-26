package com.pojo;

public class UserInfo {
    private String username;
    private int blogCount;
    private int blogColl;

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", blogCount=" + blogCount +
                ", blogColl=" + blogColl +
                '}';
    }

    public UserInfo(String username, int blogCount, int blogColl) {
        this.username = username;
        this.blogCount = blogCount;
        this.blogColl = blogColl;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(int blogCount) {
        this.blogCount = blogCount;
    }

    public int getBlogColl() {
        return blogColl;
    }

    public void setBlogColl(int blogColl) {
        this.blogColl = blogColl;
    }

    public UserInfo(int blogCount, int blogColl) {
        this.blogCount = blogCount;
        this.blogColl = blogColl;
    }
}
