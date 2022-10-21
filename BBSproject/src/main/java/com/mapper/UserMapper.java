package com.mapper;

import com.entity.Comment;
import com.entity.Post;
import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //登录判断
    int findOne(@Param("tel") String tel, @Param("pwd") String pwd);
    //更新token
    Integer updateToken(@Param("uid")int id,@Param("token") String token);
    //注册
    Integer addUser(User user);
    //上传头像
    Integer upload(String img);
    //获取id
    Integer getId(User user);
    //获取状态（是否封禁）
    Integer getStatus(User user);
    //获取板块id
    Integer getAreaId(User user);
    //发帖
    Integer addPost(Post post);
    //获取个人具体信息
    User getInfo(int id);
    //修改个人信息
    Integer modify(User user);
    //查看我所有的帖子
    List<Post> allMyPost(int id);
    //删除帖子
    Integer deletePost(int id);
    //添加评论
    Integer addComment(Comment comment);
    //获取我的评论
    List<Comment> getMyComment(int id);
}
