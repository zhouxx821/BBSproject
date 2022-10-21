package com.util;

import com.entity.User;

import java.util.List;

public class Message {
    public static String addUser01(int id) {
        if (id >= 1)
            return "add success";
        else
            return "fail";
    }
    public static int addUser02(int id) {
        if (id >= 1)
            return 1;
        else if(id==0)
            return 0;
        else
            return -1;
    }
    public static String login(int id){
        if (id >= 1)
            return "login success";
        else
            return "fail";
    }
    public static String status(int status){
        if (status == 1)
            return "normally";
        else
            return "banned";
    }
    public static String post(int status){
        if(status!=0)
            return "success";
        else
            return "fail";
    }
    public static String allUser(Object o){
        if(o!=null)
            return "success";
        else
            return "fail";
    }
    public static String banUser(int status){
        if(status>0)
            return "success";
        else
            return "fail";
    }
}
