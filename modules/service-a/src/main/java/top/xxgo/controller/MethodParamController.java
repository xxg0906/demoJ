package top.xxgo.controller;

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
    public String test(@RequestParam("name") String name) {

        return "server-a"+name;
    }
    @GetMapping("pre")
    public String pre(@RequestParam("pre") String name) {

        return "server-a"+name;
    }


}
