package com.koscom.enkore.controller;

import com.koscom.enkore.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class TestController {

    private final TestService testService;

    // select
    @GetMapping("/test") // http://127.0.0.1:8282/test
    public List<Map<String, Object>> testController() {
        return testService.testService();
    }

    // insert, update, delete
    @PostMapping("/test/insert")
    public void testInsertController(@RequestBody Map<String, Object> request) {
        testService.testInsertDao(request);
    }
}
