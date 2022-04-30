package com.pojo;

public class BlogList {
    private int id;
    private String name;
    private String createTime;
    private int blogCount;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public BlogList(int id, String name, String createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }

    public BlogList(int id, String name, String createTime, int blogCount) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.blogCount = blogCount;
    }

    public BlogList() {}

    public BlogList(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BlogList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", blogCount=" + blogCount +
                '}';
    }
}
