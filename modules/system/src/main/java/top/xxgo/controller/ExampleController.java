package top.xxgo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xxgo.util.UserInfoUtil;

/**
 * @author xxg
 */
@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @GetMapping("/index")
    public String hello(@RequestParam("access_token") String access_token) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(access_token);
        return "hello  security "+ UserInfoUtil.getUserInfo().getCountType();
    }
}
