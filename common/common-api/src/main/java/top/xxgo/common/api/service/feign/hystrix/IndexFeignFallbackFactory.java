package top.xxgo.common.api.service.feign.hystrix;


import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import top.xxgo.common.api.service.feign.IndexAFeign;


/**
 * @author xxg
 */

@Slf4j
@Component
@Primary
public class IndexFeignFallbackFactory implements FallbackFactory<IndexAFeign> {


    @Override
    public IndexAFeign create(final Throwable cause) {
//        cause.printStackTrace();
        return new IndexAFeign() {
            @Override
            public String callApi(String name) {
                cause.printStackTrace();
                return "error";
            }

            /**
             * @param name
             * @return
             */
            @Override
            public String fallbackTest(String name) {
                log.error("-------------------------");
                return "error";
            }
        };
    }
}
