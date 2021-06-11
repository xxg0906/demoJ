package top.xxgo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxg
 */
@RestController
public class IndexController {


    @GetMapping("indx")
    public  String index(){


        return "success";
    }
}
