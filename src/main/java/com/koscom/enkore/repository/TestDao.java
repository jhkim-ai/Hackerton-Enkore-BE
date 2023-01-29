package com.koscom.enkore.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestDao {

    // test-mapper.xml 의 id = TestDao.java 의 함수명

    List<Map<String, Object>> testDao();
    void testInsertDao(Map<String, Object> request);
}
