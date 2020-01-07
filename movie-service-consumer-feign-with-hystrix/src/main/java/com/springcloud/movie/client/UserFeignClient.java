package com.springcloud.movie.client;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-12-31 15:02
 **/
/*@FeignClient(name = "user-service-provider",
        fallback = HystrixClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hiRibbon();

}*/

/*@Component
class HystrixClientFallback implements UserFeignClient {

    @Override
    public String hiRibbon() {
        return "HystrixClientFallback";
    }
}*/


/**
 * fallbackFactory 打印出错误原因
 * com.netflix.client.ClientException: Load balancer does not have available server for client: user-service-provider
 */
@FeignClient(name = "user-service-provider",
        fallbackFactory = HystrixClientFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hiRibbon();

}

@Component
class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        return () -> new String(throwable.getMessage());
    }
}

