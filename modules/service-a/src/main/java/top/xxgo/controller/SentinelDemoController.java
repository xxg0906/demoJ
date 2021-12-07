package top.xxgo.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxg
 */
@RestController
@RequestMapping("sen")
public class SentinelDemoController {


    @GetMapping("hello")
    @SentinelResource("hello")
    public String foo() {
        return "hello sentinel";
    }
    @GetMapping("hello2")
    @SentinelResource("hello2")
    public String foo2() {
        return "hello sentinel";
    }

}
