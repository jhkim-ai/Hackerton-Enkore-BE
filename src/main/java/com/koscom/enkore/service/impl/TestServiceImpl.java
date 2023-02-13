package com.koscom.enkore.service.impl;

import com.koscom.enkore.repository.TestDao;
import com.koscom.enkore.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestDao testDao;

    @Override
    public List<Map<String, Object>> testService() {

        // insert 테스트
//        Map<String, Object> in = new HashMap<>();
//        in.put("userId", "하이요");
//        in.put("userName", "이름");
//        in.put("userType", "type");
//        in.put("userStat", "stat");
//        this.testInsertDao(in);

        return testDao.testDao();
    }

    @Override
    public void testInsertDao(Map<String, Object> request) {
        testDao.testInsertDao(request);
    }
}
