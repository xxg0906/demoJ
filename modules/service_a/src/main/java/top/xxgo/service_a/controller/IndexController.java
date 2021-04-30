package top.xxgo.service_a.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxg
 */
@RestController
@RefreshScope
public class IndexController {


    @Value("${testKey}")
    private String testKey;

    @GetMapping("index")
    public String index(){
        return "Hello developer "+testKey;
    }
}
