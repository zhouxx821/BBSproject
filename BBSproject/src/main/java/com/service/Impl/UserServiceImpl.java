package com.service.Impl;

import com.entity.Comment;
import com.entity.Post;
import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import com.util.Message;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.*;

public class UserServiceImpl implements UserService {

    @Override
    public Integer register(User user) throws SQLException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(UserMapper.class).addUser(user);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }
    @Override
    public List<Integer> login(User user)throws SQLException{
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Integer> list=new ArrayList<>();
        if(sqlSession.getMapper((UserMapper.class)).findOne(user.getTel(),user.getPwd())==0)
        {
            list.add(0,-1);
        }
        else{
            list.add(0,sqlSession.getMapper(UserMapper.class).findOne(user.getTel(),user.getPwd()));
            list.add(1,sqlSession.getMapper(UserMapper.class).getId(user));
            list.add(2,sqlSession.getMapper(UserMapper.class).getStatus(user));
            list.add(3,sqlSession.getMapper(UserMapper.class).getAreaId(user));
            System.out.println(list);
        }
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public Integer updateToken(int id,String token) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(UserMapper.class).updateToken(id,token);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public String upload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       return null;

    }

    @Override
    public Integer addPost(Post post) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(UserMapper.class).addPost(post);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public User getInfo(int id) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        User user=sqlSession.getMapper(UserMapper.class).getInfo(id);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public Integer modify(User user) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(UserMapper.class).modify(user);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public List<Post> allMyPost(int id) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        List<Post> list=sqlSession.getMapper(UserMapper.class).allMyPost(id);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public Integer deletePost(int id) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(UserMapper.class).deletePost(id);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public Integer addComment(Comment comment) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(UserMapper.class).addComment(comment);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public List<Comment> getMyComment(int id) {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        List<Comment> list=sqlSession.getMapper(UserMapper.class).getMyComment(id);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }


}
