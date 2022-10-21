package com.service.Impl;

import com.entity.User;
import com.mapper.ManagerMapper;
import com.service.ManagerService;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {

    @Override
    public User judgeM(String tel, String pwd) {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        User user=sqlSession.getMapper(ManagerMapper.class).judgeM(tel,pwd);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> allUsers() {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        List<User> list=sqlSession.getMapper(ManagerMapper.class).allUser();
        sqlSession.commit();
        sqlSession.close();
        return list;

    }

    @Override
    public Integer getResultCount() {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        int rs=sqlSession.getMapper(ManagerMapper.class).getResultCount();
        sqlSession.commit();
        sqlSession.close();
        return rs;
    }

    @Override
    public Integer banUser(int id) {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(ManagerMapper.class).banUser(id);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public Integer release(int id) {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(ManagerMapper.class).release(id);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public Integer addType(String name) {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        int id=sqlSession.getMapper(ManagerMapper.class).addType(name);
        sqlSession.commit();
        sqlSession.close();
        return id;
    }

    @Override
    public Integer deleteType(String name,int id) {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        sqlSession.getMapper(ManagerMapper.class).setNormal(id);
        int status=sqlSession.getMapper(ManagerMapper.class).deleteType(name);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }

    @Override
    public Integer setPoster(int uid, int id) {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        int status=sqlSession.getMapper(ManagerMapper.class).setPoster(uid,id);
        sqlSession.commit();
        sqlSession.close();
        return status;
    }


}
