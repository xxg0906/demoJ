package top.xxgo.common.api.service.feign.hystrix;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
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
    public IndexAFeign create(final Throwable throwable) {
        return new IndexAFeign() {
            @Override
            public String callApi() {
                log.error(throwable.getMessage());
                return "error2";
            }
        };
    }
}
