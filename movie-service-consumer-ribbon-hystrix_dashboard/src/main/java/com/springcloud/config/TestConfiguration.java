package com.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }

}