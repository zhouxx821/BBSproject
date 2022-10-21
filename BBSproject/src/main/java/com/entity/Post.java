package com.entity;

public class Post {
    private int id,uid,cnum,anum,tid;
    private String img,title,note,name;
    private String pubtime;
    private int istop;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPubtime() {
        return pubtime;
    }

    public int getAnum() {
        return anum;
    }

    public int getCnum() {
        return cnum;
    }

    public int getUid() {
        return uid;
    }

    public String getImg() {
        return img;
    }

    public String getNote() {
        return note;
    }

    public String getTitle() {
        return title;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setAnum(int anum) {
        this.anum = anum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setIstop(int istop) {
        this.istop = istop;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
