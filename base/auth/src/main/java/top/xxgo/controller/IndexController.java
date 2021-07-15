package top.xxgo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author xxg
 */
@RestController
public class IndexController {


    @GetMapping("index")
    public String index(){

        return "success";
    }
}
