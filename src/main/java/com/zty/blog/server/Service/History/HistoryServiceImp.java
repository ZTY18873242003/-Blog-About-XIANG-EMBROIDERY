package com.zty.blog.server.Service.History;

import com.zty.blog.server.Dao.Article;
import com.zty.blog.server.Dao.History;
import com.zty.blog.server.Entity.ArtClass;
import com.zty.blog.server.Entity.HistoryClass;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class HistoryServiceImp implements HistoryService{
    @Override
    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";//通过流处理获取sqlSessionFactory创建一个实例
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();//获取SqlSession实例
        return session;
    }

    @Override
    public List<HistoryClass> getHistoryClass() throws IOException {
        SqlSession sqlSession=getSqlSession();
        List<HistoryClass> artClassList = sqlSession.getMapper(History.class).getHistoryClass();
        return artClassList;
    }
}
