package com.pojo;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String lastLoginTime;
    private String time;
    private String selfDesc;
    private String major;
    private String company;
    private String job;
    private String graduateSchool;
    private int expertFlag;
    private String offcialDesc;

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", time='" + time + '\'' +
                ", selfDesc='" + selfDesc + '\'' +
                ", major='" + major + '\'' +
                ", company='" + company + '\'' +
                ", job='" + job + '\'' +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", expertFlag=" + expertFlag +
                ", offcialDesc='" + offcialDesc + '\'' +
                '}';
    }

    public User(Integer id, String username, String password, String name, String lastLoginTime, String time, String selfDesc, String major, String company, String job, String graduateSchool, int expertFlag, String offcialDesc) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastLoginTime = lastLoginTime;
        this.time = time;
        this.selfDesc = selfDesc;
        this.major = major;
        this.company = company;
        this.job = job;
        this.graduateSchool = graduateSchool;
        this.expertFlag = expertFlag;
        this.offcialDesc = offcialDesc;
    }

    public int getExpertFlag() {
        return expertFlag;
    }

    public void setExpertFlag(int expertFlag) {
        this.expertFlag = expertFlag;
    }

    public String getOffcialDesc() {
        return offcialDesc;
    }

    public void setOffcialDesc(String offcialDesc) {
        this.offcialDesc = offcialDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSelfDesc() {
        return selfDesc;
    }

    public void setSelfDesc(String selfDesc) {
        this.selfDesc = selfDesc;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }
}
