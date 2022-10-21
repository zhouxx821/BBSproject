package com.service;

import com.entity.User;

import java.util.List;

public interface ManagerService {
    //判断管理员身份
    User judgeM(String tel,String pwd);
    //获取所有用户
    List<User> allUsers();
    //获取查询到的数目
    Integer getResultCount();
    //封禁用户
    Integer banUser(int id);
    //解除封禁
    Integer release(int id);
    //添加板块
    Integer addType(String name);
    //删除板块
    Integer deleteType(String name,int id);
    //设置版主
    Integer setPoster(int uid,int id);
}
