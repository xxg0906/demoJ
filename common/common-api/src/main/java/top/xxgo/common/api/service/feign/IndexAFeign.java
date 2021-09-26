package top.xxgo.common.api.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.xxgo.common.api.service.feign.hystrix.IndexFeignFallbackFactory;
//import top.xxgo.common.api.service.feign.hysrtrix.IndexFeignHysrtrix;

/**
 * @author xxg
 */
@FeignClient(value="service-a" ,fallbackFactory= IndexFeignFallbackFactory.class)
public interface IndexAFeign {


    /**
     *
     * @return
     */
    @GetMapping("cloudApi")
    String callApi(@RequestParam("name") String name);

    /**
     *
     * @return
     */
    @GetMapping("fallbackTest")

    String fallbackTest(@RequestParam("name") String name);

}
