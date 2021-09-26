package top.xxgo.common.api.service.feign.hystrix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.xxgo.common.api.service.feign.IndexAFeign;

/**
 * @author xxg
 */

@Slf4j
@Component
public class IndexFeignHysrtrix implements IndexAFeign {


    @Override
    public String callApi(String name) {
        log.error("error");
        return "error";
    }

    /**
     * @param name
     * @return
     */
    @Override
    public String fallbackTest(String name) {
//        throw new NullPointerException();
        log.info("----------"+ name);
        return "error";
    }
}
