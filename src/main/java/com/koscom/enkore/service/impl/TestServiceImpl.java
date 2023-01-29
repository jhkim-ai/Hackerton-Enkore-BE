package com.koscom.enkore.service.impl;

import com.koscom.enkore.repository.TestDao;
import com.koscom.enkore.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestDao testDao;

    @Override
    public List<Map<String, Object>> testService() {
        return testDao.testDao();
    }
}
