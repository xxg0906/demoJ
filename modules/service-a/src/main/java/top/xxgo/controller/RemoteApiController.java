package top.xxgo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import top.xxgo.common.api.service.feign.IndexAFeign;

/**
 * @author xxg
 */
@RestController
@Slf4j
public class RemoteApiController implements IndexAFeign {



    @Override
    public String callApi(String name) {
        return name;
    }

    @Override
    public String fallbackTest(String name) {
        log.info("-------------" +name);
        String s=null;
//        String ss=s.trim();
//        int ss =0/0;
        throw new NullPointerException();
    }
}
