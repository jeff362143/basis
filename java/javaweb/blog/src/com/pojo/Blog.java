package com.pojo;

public class Blog {
    private int id;
    private String title;
    private String createTime;
    private String content;
    private String author;
    private String marked;

    public String getMarked() {
        return marked;
    }

    public void setMarked(String marked) {
        this.marked = marked;
    }

    public Blog() {
    }

    public Blog(int id, String title, String content, String createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public Blog(String title, String createTime, String content, String author, String marked) {
        this.title = title;
        this.createTime = createTime;
        this.content = content;
        this.author = author;
        this.marked = marked;
    }

    public Blog(int id, String title, String content, String createTime, String author) {
        this.author = author;
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public Blog(int id, String title, String createTime, String content, String author, String marked) {
        this.id = id;
        this.title = title;
        this.createTime = createTime;
        this.content = content;
        this.author = author;
        this.marked = marked;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createTime='" + createTime + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", marked='" + marked + '\'' +
                '}';
    }
}
