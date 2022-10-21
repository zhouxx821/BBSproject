package com.service;

import com.entity.Area;
import com.entity.Comment;
import com.entity.Post;

import java.util.ArrayList;
import java.util.List;

public interface PostService {
    //获取所有板块信息
    List<Area> type();
    //获取所有帖子
    List<Post> posts();
    //获取查询到的数目
    Integer getResultCount();
    //获取板块id
    Integer getTid(String type);
    //获取板块名
    String getName(int id);
    //帖子点赞量增加
    Integer addLikes(int pid);
    //获取某板块的所有帖子
    List<Post> getPosts(int tid);
    //获取板块查询到的数目
    Integer getTypeResultCount(int tid);
    //根据帖子的id获取帖子的具体信息
    Post getInfo(int id);
    //判断帖子是不是某用户发的
    Boolean judgePost(int uid,int id);
    //获取帖子下的所有回复
    List<Comment> getComments(int pid);
    //删除评论
    Integer deleteComment(int id);
    //将帖子设为置顶
    Integer topPost(int id);
    //将帖子移动至其他板块
    Integer movePost(int id,int tid);
    //获取热门帖
    List<Post> getHot();
    //获取板块热门帖
    List<Post> getTypeHot(int tid);
}
