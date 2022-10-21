package com.service.Impl;

import com.entity.Area;
import com.entity.Comment;
import com.entity.Post;
import com.mapper.PostMapper;
import com.service.PostService;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PostServiceImpl implements PostService {

    @Override
    public List<Area> type() {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        List<Area> areas=sqlSession.getMapper(PostMapper.class).getArea();
        sqlSession.commit();
        sqlSession.close();
        return areas;
    }

    @Override
    public List<Post> posts() {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        List<Post> post=sqlSession.getMapper(PostMapper.class).post();
        sqlSession.commit();
        sqlSession.close();
        return post;
    }

    @Override
    public Integer getResultCount() {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        int rc=sqlSession.getMapper(PostMapper.class).getResultCount();
        sqlSession.commit();
        sqlSession.close();
        return rc;
    }

    @Override
    public Integer getTid(String type) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        Integer id=sqlSession.getMapper(PostMapper.class).getTid(type);
        sqlSession.commit();
        sqlSession.close();
        return id;
    }

    @Override
    public String getName(int id) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        String name=sqlSession.getMapper(PostMapper.class).getName(id);
        sqlSession.commit();
        sqlSession.close();
        return name;
    }

    @Override
    public Integer addLikes(int pid) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        Integer status=sqlSession.getMapper(PostMapper.class).addLikes(pid);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public List<Post> getPosts(int tid) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        List<Post> list=sqlSession.getMapper(PostMapper.class).getTopPosts(tid);
        list.addAll(sqlSession.getMapper(PostMapper.class).getNoPosts(tid));
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public Integer getTypeResultCount(int tid) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        int rc=sqlSession.getMapper(PostMapper.class).getTypeResultCount(tid);
        sqlSession.commit();
        sqlSession.close();
        return rc;
    }

    @Override
    public Post getInfo(int id) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        Post post=sqlSession.getMapper(PostMapper.class).getInfo(id);
        sqlSession.commit();
        sqlSession.close();
        return post;
    }

    @Override
    public Boolean judgePost(int uid, int id) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        int uid2=sqlSession.getMapper(PostMapper.class).getPostUid(id);
        sqlSession.commit();
        sqlSession.close();
        if(uid==uid2)
            return true;
        else
            return false;
    }

    @Override
    public List<Comment> getComments(int pid) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        List<Comment> list=sqlSession.getMapper(PostMapper.class).getComments(pid);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public Integer deleteComment(int id) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(PostMapper.class).deleteComment(id);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public Integer topPost(int id) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(PostMapper.class).topPost(id);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public Integer movePost(int id, int tid) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(PostMapper.class).movePost(id,tid);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public List<Post> getHot() {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        List<Post> list=sqlSession.getMapper(PostMapper.class).getHot();
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<Post> getTypeHot(int tid) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        List<Post> list=sqlSession.getMapper(PostMapper.class).getTypeHot(tid);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

}
