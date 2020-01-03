package com.springcloud.discovery.controller;

import com.springcloud.discovery.entity.User;
import com.springcloud.discovery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-08-21 16:15
 **/
@RestController
public class HelloWorldController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hi")
    private String helloWorld() {

        System.out.println(111);

        return "hi eureka client";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        User one = this.userRepository.getOne(id);
        return one;
    }

}