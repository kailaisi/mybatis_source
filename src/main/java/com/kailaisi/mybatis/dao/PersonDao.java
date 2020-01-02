package com.kailaisi.mybatis.dao;

import com.kailaisi.mybatis.model.Person;

public interface PersonDao {
     int insert(Person p);
     int update(Person p);
}