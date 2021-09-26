package top.xxgo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xxg
 */
@RestController
@RefreshScope
//@RequestMapping("a")
public class IndexController {


    @Value("${testKey:123}")
    private String key;

    @Value("${test}")
    private String test;

    @GetMapping("npe")
    public String callApi() {
        throw new NullPointerException("sssss");
//        return "hello this service a "+key;
    }

    @GetMapping("")
    public String index() {
        return "sssss";
//        return "hello this service a "+key;
    }

    @GetMapping("test")
    public String test() {
        return test;
    }


}
