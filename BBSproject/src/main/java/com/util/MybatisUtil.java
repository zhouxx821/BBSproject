package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
        private static SqlSessionFactory factory = null;

        static {
            try {
                InputStream in = Resources.getResourceAsStream("cn/kgc/mybatis-config.xml");
                SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
                factory = builder.build(in);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        //获取SqlSession对象
        public static SqlSession getSqlSession(){
            SqlSession sqlSession = null;
            if(factory!=null){
                sqlSession = factory.openSession();
            }
            return sqlSession;
        }

}
