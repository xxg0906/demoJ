package top.xxgo.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import top.xxgo.common.projectBase.utils.StringUtils;
import top.xxgo.config.AuthIgnoreProperties;

import java.util.List;


/**
 * @author xxg
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Autowired
    AuthIgnoreProperties authIgnoreProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //auth 白名单
        String path = exchange.getRequest().getURI().getPath();
        boolean ignoreMatch= StringUtils.matches(path, authIgnoreProperties.getIgnores());
       if(ignoreMatch){
           return chain.filter(exchange);
       }
        //获取请求token

        //校验token
        //刷新token过期时间
        //缓存用户信息至请求



        return null;
    }

    @Override
    public int getOrder() {
        return -200;
    }
}
