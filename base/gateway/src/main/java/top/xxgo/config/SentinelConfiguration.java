//package top.xxgo.config;
//
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import org.springframework.web.reactive.resource.ResourceWebHandler;
//import top.xxgo.common.core.web.domain.ResultCode;
//
//import javax.annotation.PostConstruct;
//import java.util.Map;
//
///**
// * 自定义网关流控异常响应
// * @author haoxr
// */
//@Configuration
//public class SentinelConfiguration {
//
//    @PostConstruct
//    private void initBlockHandler() {
//        BlockRequestHandler blockRequestHandler = (exchange, t) ->
//                ServerResponse.status(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(BodyInserters.fromValue(ResultCode.FLOW_LIMITING.toString()));
//        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
//    }
//
//}
