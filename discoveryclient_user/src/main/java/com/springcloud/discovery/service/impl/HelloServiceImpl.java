package com.springcloud.discovery.service.impl;

import com.springcloud.discovery.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-08-21 17:00
 **/
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String hello() {
        // return restTemplate.;
        return "";
    }
}