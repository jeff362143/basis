package com.pojo;


public class UserMessage {
    int id;
    private String user;
    private String message;
    private String time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserMessage() {
    }

    public UserMessage(String user, String message, String time) {
        this.user = user;
        this.message = message;
        this.time = time;
    }

    public UserMessage(int id, String user, String message, String time) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

