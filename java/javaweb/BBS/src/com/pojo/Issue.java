package com.pojo;

public class Issue {
    private int id;
    private String author;
    private String title;
    private String content;
    private String time;
    private String marked;
    private int reco;

    public Issue() {
    }

    public Issue(int id, String author, String title, String content, String time, String marked, int reco) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.time = time;
        this.marked = marked;
        this.reco = reco;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMarked() {
        return marked;
    }

    public void setMarked(String marked) {
        this.marked = marked;
    }

    public int getReco() {
        return reco;
    }

    public void setReco(int reco) {
        this.reco = reco;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", marked='" + marked + '\'' +
                ", reco=" + reco +
                '}';
    }
}
