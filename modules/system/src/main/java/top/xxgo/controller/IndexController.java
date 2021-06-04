package top.xxgo.controller;

//Controller.java

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.xxgo.annotation.PreAuthorize;

/**
 * @author zhanghui
 * @date 2019/4/24
 */
@RestController("index")
//@ResponseBody
public class IndexController {
    @PreAuthorize(hasPermi = ":list")
    @GetMapping(value = {"/",""})
    public String defaut(){
        return "defaut";
    }
    @PreAuthorize(hasPermi = ":list")
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    // direct request to "/logout" for logout
    @RequestMapping("/login")
    public String login(){
        return "<form action=\"/login\" method=\"post\">\n" +
                "  <label for=\"username\">Username</label>:\n" +
                "  <input type=\"text\" id=\"username\" name=\"username\" autofocus=\"autofocus\" /> <br />\n" +
                "  <label for=\"password\">Password</label>:\n" +
                "  <input type=\"password\" id=\"password\" name=\"password\" /> <br />\n" +
                "  <input type=\"submit\" value=\"Login\" />\n" +
                "</form>";
    }
    @GetMapping("/login-error")
    public String loginerror(){
        return "login-error";
    }

//  @PreAuthorize("hasRole('user')")    //同上，判断角色，会自动加 前缀 ROLE_
    @GetMapping("/list")
    public String list() {
        //程序内判断role
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_user"))){
            System.out.println("user role2");
        }
        return "to list";
    }

    @GetMapping("/add")
    public String add() {
        return "to add";
    }
}
