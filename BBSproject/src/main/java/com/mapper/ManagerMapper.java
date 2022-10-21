package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerMapper {
    //判断管理员身份
    User judgeM(@Param("tel") String tel, @Param("pwd") String pwd);
    //获取所有用户
    List<User> allUser();
    //获取查询到的数目
    Integer getResultCount();
    //封禁用户
    Integer banUser(int id);
    //解除封禁
    Integer release(int id);
    //添加板块
    Integer addType(String name);
    //删除板块
    Integer deleteType(String name);
    //设置版主
    Integer setPoster(@Param("uid") int uid,@Param("id") int id);
    //取消版主身份
    Integer setNormal(int id);
}
