package com.springcloud.movie.client;

import feign.Feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-12-31 15:02
 **/
@FeignClient(name = "user-service-provider",
        fallback = HystrixClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hiRibbon();

}

@Component
class HystrixClientFallback implements UserFeignClient {

    @Override
    public String hiRibbon() {
        return "HystrixClientFallback";
    }

    //禁用hystrix
    /*@Bean
    @Scope("prototype")
    public Feign.Builder feignHystrixBuilder() {
        return Feign.builder();
    }
*/
}
