package com.mapper;

import com.entity.Area;
import com.entity.Comment;
import com.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface PostMapper {
    //所有板块
    List<Area> getArea();
    //获取所有帖子
    List<Post> post();
    //获取查询到的数目
    Integer getResultCount();
    //获取板块id
    Integer getTid(String type);
    //获取板块名
    String getName(int id);
    //点赞
    Integer addLikes(int tid);
    //获取某板块下帖子
    List<Post> getTopPosts(int tid);
    //获取板块查询数目
    Integer getTypeResultCount(int tid);
    //获取某板块下不置顶的帖子
    List<Post> getNoPosts(int tid);
    //获取帖子相关信息
    Post getInfo(int id);
    //获取帖子uid
    Integer getPostUid(int id);
    //获取评论
    List<Comment> getComments(int pid);
    //删除评论
    Integer deleteComment(int id);
    //置顶帖子
    Integer topPost(int id);
    //将帖子移动到其他板块
    Integer movePost(@Param("id") int id,@Param("tid")int tid);
    //获取热门帖子
    List<Post> getHot();
    //获取板块热门帖子
    List<Post> getTypeHot(int tid);
}
