package top.xxgo.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxg
 */

@RestController
public class BaseImplController implements  BaseController {



    final static   String  requestMapping="type";
    @GetMapping("hello")
    @SentinelResource("hello")
    public String foo() {
        return "hello sentinel";
    }
    @GetMapping("hello2")
    public String foo2() {
        return "hello sentinel";
    }

}
