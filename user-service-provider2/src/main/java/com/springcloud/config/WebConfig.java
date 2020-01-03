package com.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-09-17 17:46
 **/
@Configuration
public class WebConfig {

    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }

}