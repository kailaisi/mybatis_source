package com.kailaisi;

import com.kailaisi.mybatis.SqlSessionFactoryUtil;
import com.kailaisi.mybatis.dao.PersonDao;
import com.kailaisi.mybatis.model.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonDao personDao =  sqlSession.getMapper(PersonDao.class);
        Person p = new Person();
        p.setAddress("广东省");
        p.setAge(12);
        p.setEmail("157538651@qq.com");
        p.setName("chen");
        p.setPhone("15345634565");
        personDao.insert(p);
        System.out.println(p.toString());
        sqlSession.commit();
        sqlSession.close();
    }
}
