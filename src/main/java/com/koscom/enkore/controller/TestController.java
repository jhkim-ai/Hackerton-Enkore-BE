package com.koscom.enkore.controller;

import com.koscom.enkore.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public List<Map<String, Object>> testController() {
        return testService.testService();
    }
}
