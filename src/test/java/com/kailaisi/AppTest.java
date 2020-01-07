package com.kailaisi;

import static org.junit.Assert.assertTrue;

import com.kailaisi.mybatis.SqlSessionFactoryUtil;
import com.kailaisi.mybatis.dao.PersonDao;
import com.kailaisi.mybatis.model.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void main() throws IOException {
        String path = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonDao personDao =  sqlSession.getMapper(PersonDao.class);
        Person p = new Person();
        p.setName("chen");
        p.setAge(10);
        personDao.update(p);
        sqlSession.commit();
        sqlSession.close();
    }
}
