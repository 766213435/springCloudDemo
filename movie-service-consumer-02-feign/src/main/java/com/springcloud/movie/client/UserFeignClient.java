package com.springcloud.movie.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-12-31 15:02
 **/
@FeignClient("user-service-provider")
public interface UserFeignClient {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hiRibbon();

}
