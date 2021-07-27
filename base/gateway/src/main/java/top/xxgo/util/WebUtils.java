//package top.xxgo.util;
//
//import cn.hutool.json.JSONUtil;
//
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.core.io.buffer.DataBufferUtils;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import reactor.core.publisher.Mono;
//import top.xxgo.common.core.web.domain.RestApiResult;
//import top.xxgo.common.core.web.domain.ResultCode;
//
//
//import java.nio.charset.StandardCharsets;
//
///**
// *
// * @author xxg
// */
//public class WebUtils {
//
//    public static Mono<Void> writeFailedToResponse(ServerHttpResponse response, ResultCode resultCode) {
//        response.setStatusCode(HttpStatus.OK);
//        response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//        response.getHeaders().set("Access-Control-Allow-Origin", "*");
//        response.getHeaders().set("Cache-Control", "no-cache");
//        String body = JSONUtil.toJsonStr(RestApiResult.fail(resultCode));
//        DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
//        return response.writeWith(Mono.just(buffer))
//                .doOnError(error -> DataBufferUtils.release(buffer));
//    }
//
//}
