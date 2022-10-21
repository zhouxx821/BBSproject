package com.entity;

public class Comment {
    private int id;
    private int pid,aid;
    private String pubtime;
    private String text;
    private int status;

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public int getAid() {
        return aid;
    }

    public int getPid() {
        return pid;
    }

    public String getPubtime() {
        return pubtime;
    }

    public String getText() {
        return text;
    }
}
