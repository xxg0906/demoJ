package top.xxgo.serviceb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xxgo.common.api.service.feign.IndexAFeign;


/**
 * @author xxg
 */
@RestController
public class IndexController {

    @Lazy
    @Autowired
    private IndexAFeign indexAFeign;

    @GetMapping("index")
    public String index() {
        return  indexAFeign.callApi();
//        return  "success";
    }

}
