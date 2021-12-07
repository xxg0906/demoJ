package top.xxgo.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxg
 */
@RestController
@SentinelResource("${spring.application.name}")
public interface BaseController {


}
