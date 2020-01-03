package com.springcloud.user.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-08-27 17:56
 **/
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${user.userService}")
    private String userServicePath;

    @GetMapping("/eureka_instance")
    public String eurekaInstance() {
        InstanceInfo stores = eurekaClient.getNextServerFromEureka("RIBBON", false);
        return stores.getHomePageUrl();
    }

    @GetMapping("/hi")
    public String hiRibbon() {

        return "{'result':'success'}";
    }

    @GetMapping("/hiRibbon/{id}")
    public String hiRibbon(@PathVariable Integer id) {


        ServiceInstance choose = this.loadBalancerClient.choose("service-provider");
        System.out.println(choose.getHost() + ":" + choose.getPort());

        //当url需参数，且参数很长时，就不好拼接了，引入feign
        String forObject = restTemplate.getForObject(userServicePath + id, String.class);

        return forObject;
    }
}