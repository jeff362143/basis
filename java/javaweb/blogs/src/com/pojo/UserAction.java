package com.pojo;

public class UserAction {
    private int id;
    private String username;
    private String lastWriteTime;
    private int selfBlogNumber;
    private int selfCollBlogNumber;
    private int followedUserCount;
    private int commentCount;
    private String desc;
    private int likeBlogCount;

    public UserAction() {
    }

    public UserAction( String username, String lastWriteTime, int selfBlogNumber, int selfCollBlogNumber, int followedUserCount, int commentCount, String desc, int likeBlogCount) {
        this.username = username;
        this.lastWriteTime = lastWriteTime;
        this.selfBlogNumber = selfBlogNumber;
        this.selfCollBlogNumber = selfCollBlogNumber;
        this.followedUserCount = followedUserCount;
        this.commentCount = commentCount;
        this.desc = desc;
        this.likeBlogCount = likeBlogCount;
    }

    public UserAction(String username, String lastWriteTime, int selfBlogNumber, int selfCollBlogNumber, int followedUserCount, int commentCount) {
        this.username = username;
        this.lastWriteTime = lastWriteTime;
        this.selfBlogNumber = selfBlogNumber;
        this.selfCollBlogNumber = selfCollBlogNumber;
        this.followedUserCount = followedUserCount;
        this.commentCount = commentCount;
    }

    public UserAction(String username, String lastWriteTime, int selfBlogNumber, int selfCollBlogNumber, int followedUserCount, int commentCount, String desc) {
        this.username = username;
        this.lastWriteTime = lastWriteTime;
        this.selfBlogNumber = selfBlogNumber;
        this.selfCollBlogNumber = selfCollBlogNumber;
        this.followedUserCount = followedUserCount;
        this.commentCount = commentCount;
        this.desc = desc;
    }

    public UserAction(int id,String username, String lastWriteTime, int selfBlogNumber, int selfCollBlogNumber, int followedUserCount, int commentCount, int likeBlogCount) {
        this.id = id;
        this.username = username;
        this.lastWriteTime = lastWriteTime;
        this.selfBlogNumber = selfBlogNumber;
        this.selfCollBlogNumber = selfCollBlogNumber;
        this.followedUserCount = followedUserCount;
        this.commentCount = commentCount;
        this.likeBlogCount = likeBlogCount;
    }

    public UserAction(int id, String username, String lastWriteTime, int selfBlogNumber, int selfCollBlogNumber, int followedUserCount, int commentCount) {
        this.id = id;
        this.username = username;
        this.lastWriteTime = lastWriteTime;
        this.selfBlogNumber = selfBlogNumber;
        this.selfCollBlogNumber = selfCollBlogNumber;
        this.followedUserCount = followedUserCount;
        this.commentCount = commentCount;
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

    public String getLastWriteTime() {
        return lastWriteTime;
    }

    public void setLastWriteTime(String lastWriteTime) {
        this.lastWriteTime = lastWriteTime;
    }

    public int getSelfBlogNumber() {
        return selfBlogNumber;
    }

    public void setSelfBlogNumber(int selfBlogNumber) {
        this.selfBlogNumber = selfBlogNumber;
    }

    public int getSelfCollBlogNumber() {
        return selfCollBlogNumber;
    }

    public void setSelfCollBlogNumber(int selfCollBlogNumber) {
        this.selfCollBlogNumber = selfCollBlogNumber;
    }

    public int getFollowedUserCount() {
        return followedUserCount;
    }

    public void setFollowedUserCount(int followedUserCount) {
        this.followedUserCount = followedUserCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "UserAction{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", lastWriteTime='" + lastWriteTime + '\'' +
                ", selfBlogNumber=" + selfBlogNumber +
                ", selfCollBlogNumber=" + selfCollBlogNumber +
                ", followedUserCount=" + followedUserCount +
                ", commentCount=" + commentCount +
                ", desc='" + desc + '\'' +
                ", likeBlogCount=" + likeBlogCount +
                '}';
    }
}
