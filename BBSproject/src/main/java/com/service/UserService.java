package com.service;

import com.entity.Comment;
import com.entity.Post;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    //注册
    Integer register(User user) throws SQLException;
    //登录
    List<Integer> login(User user)throws SQLException;
    //更新token
    Integer updateToken(int id,String token);
    //上传头像
    String upload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
    //发布帖子
    Integer addPost(Post post);
    //获取“我”的相关信息
    User getInfo(int id);
    //修改信息
    Integer modify(User user);
    //获取“我”发布的所有帖子
    List<Post> allMyPost(int id);
    //删除某个帖子
    Integer deletePost(int id);
    //回复帖子
    Integer addComment(Comment comment);
    //获取“我”的所有评论
    List<Comment> getMyComment(int id);
}
