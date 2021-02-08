package com.quan.redistest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: qubingquan
 * @Date: 2021/2/8 3:35 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestClass {

    @Autowired
    TestService testService;

//    @Test
//    public void test(){
//        testService.saveUserAccessLog();
//        System.out.println("哈哈");
//    }

    @Test
    public void testAdd(){
        int res = testService.add(1,2);
        System.out.println(res);
    }
}
