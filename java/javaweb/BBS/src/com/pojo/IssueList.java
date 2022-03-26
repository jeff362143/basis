package com.pojo;

public class IssueList  {
    private  int id;
    private  String name;

    public IssueList(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public IssueList() {
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
        return "issueList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
