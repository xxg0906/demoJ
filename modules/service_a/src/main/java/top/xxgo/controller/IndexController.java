package top.xxgo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.web.bind.annotation.RestController;



/**
 * @author xxg
 */
@RestController
@RefreshScope
public class IndexController   {



@Value("${testKey:123}")
private String key;

    public String callApi() {
        throw new NullPointerException("sssss");
//        return "hello this service a "+key;
    }
}
