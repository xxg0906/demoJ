package top.xxgo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxg
 */
@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @GetMapping("/index")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "hello  security";
    }
}
