package com.test.provider.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.test.provider.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghao.29
 * @date 2020/10/23
 */
@RestController
public class TestController {

    @Reference(interfaceName = "com.test.provider.service.TestService", url = "dubbo://127.0.0.1:20880", check = false)
    private TestService testService;

    @GetMapping("/hello")
    public String sayHello(String name){
        return testService.sayHello(name);
    }
}
