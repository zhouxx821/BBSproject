package com.entity;

public class User {
        private Integer uid;
        private String uname,tname,sex;
        private String tel,email,img;
        private String pwd;
        private Integer utype,areaId,status;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUid(int uid) {
        this.uid=uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUtype(Integer utype) {
        this.utype = utype;
    }

    public String getPwd() {
        return pwd;
    }

    public Integer getUtype() {
        return utype;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public Integer getUid() {
        return uid;
    }

    public String getTname() {
        return tname;
    }

    public String getUname() {
        return uname;
    }


}
