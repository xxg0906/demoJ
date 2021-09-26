package top.xxgo.serviceb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xxg
 */
@RestController
@RefreshScope
@RequestMapping({"method"})
public class MethodParamController {



    @GetMapping("test")
    public String test(@RequestParam("name2") String name) {

        return "server-b"+name;
    }

    @GetMapping("pre")
    public String pre(@RequestParam("pre") String name) {

        return "server-b"+name;
    }
}
