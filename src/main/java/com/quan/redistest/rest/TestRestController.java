package com.quan.redistest.rest;

import com.quan.redistest.service.TestService;
import com.quan.redistest.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("test")
public class TestRestController {

    @Autowired
    private TestService testService;

    @RequestMapping("count")
    public String saveUserActivity(HttpServletRequest request){
        testService.saveUserActivity(request);
        return "保存成功";
    }

}
