package top.xxgo.serviceb.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xxgo.common.api.service.feign.IndexAFeign;


/**
 * @author xxg
 */
@RestController
@Slf4j
@RequestMapping("v5")
public class IndexController {


    @Autowired
    private IndexAFeign indexAFeign;


    @GetMapping
    public  String  index(){
       return indexAFeign.callApi("service-b");
    }
    @GetMapping("test")
    public  String  fallbackTest(){
        String s = indexAFeign.fallbackTest("service-b");
        log.info("--------------------"+s);
        return "success";
    }

}
