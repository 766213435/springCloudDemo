package com.springcloud.movie.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-08-27 17:56
 **/
@RestController
public class MovieController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/eureka_instance")
    public String eurekaInstance() {
        InstanceInfo stores = eurekaClient.getNextServerFromEureka("RIBBON", false);
        return stores.getHomePageUrl();
    }

    @GetMapping("/hiUser")
    @HystrixCommand     //dashboard一定要加这个注解
    public String hiRibbon() {

        ServiceInstance choose = this.loadBalancerClient.choose("user-service-provider");
        System.out.println(choose.getHost() + ":" + choose.getPort());
        //当url需参数，且参数很长时，就不好拼接了，引入feign
        String forObject = restTemplate.getForObject("http://user-service-provider/hi", String.class);

        return forObject;
    }

}