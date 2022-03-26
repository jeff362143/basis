package com.pojo;

public class ComplainBlog  {
    private int id;
    private int blogid;
    private String title;
    private String complainer;
    private String blogAuthor;
    private String time;

    public ComplainBlog() {
    }

    public ComplainBlog(int id, int blogid, String title, String complainer, String blogAuthor, String time) {
        this.id = id;
        this.blogid = blogid;
        this.title = title;
        this.complainer = complainer;
        this.blogAuthor = blogAuthor;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComplainer() {
        return complainer;
    }

    public void setComplainer(String complainer) {
        this.complainer = complainer;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
