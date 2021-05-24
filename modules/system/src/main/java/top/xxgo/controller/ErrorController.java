package top.xxgo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * @author xxg
 */
//@RestController
//@SessionAttributes("authorizationRequest")
@Slf4j
public class ErrorController {



    @RequestMapping("/oauth/error")
    public String error(@RequestParam Map<String,String> parmas){
            String url=parmas.get("redirect_uri");
        return "redirect:" +url+"?error=1";
    }
}
