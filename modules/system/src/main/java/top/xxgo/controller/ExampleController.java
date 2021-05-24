package top.xxgo.controller;

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
        return "hello  security";
    }
}
