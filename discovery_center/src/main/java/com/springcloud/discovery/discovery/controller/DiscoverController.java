package com.springcloud.discovery.discovery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-08-27 17:56
 **/
@RestController
public class DiscoverController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hiRibbon")
    public String hiRibbon() {


        //当url需参数，且参数很长时，就不好拼接了，引入feign
        String forObject = restTemplate.getForObject("http://ribbon/hi", String.class);

        return forObject;
    }

    @GetMapping("/hiUser")
    public String hiUser() {

        ServiceInstance choose = this.loadBalancerClient.choose("user-service-provider");
        System.out.println(choose.getHost() + ":" + choose.getPort());
        //当url需参数，且参数很长时，就不好拼接了，引入feign
        String forObject = restTemplate.getForObject("http://user-service-provider/hi", String.class);

        return forObject;
    }
}