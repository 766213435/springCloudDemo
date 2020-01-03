package com.springcloud.movie.controller;

import com.springcloud.movie.client.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-08-27 17:56
 **/
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/hiUser")
    public String hiRibbon() {

        return userFeignClient.hiRibbon();
    }

}