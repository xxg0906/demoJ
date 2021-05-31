package top.xxgo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndpoints {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id : " + id;
    }

    public static void main(String[] args) {
        String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhYmMiLCJqd3QtZXh0IjoiSldUIOaJqeWxleS_oeaBryIsInNjb3BlIjpbInNlbGVjdCJdLCJleHAiOjE2MjI0NjY2MDgsImF1dGhvcml0aWVzIjpbIlJPTEVfYWRtaW4iLCJST0xFX3VzZXIiXSwianRpIjoiNmRhZTQxNjQtNjRiMi00ZWYxLWFkNDgtNmRmZjI5Njg5YWM0IiwiY2xpZW50X2lkIjoiY2xpZW50MTExMSJ9.zYt-751I8EMyQewbQdftpuBwiuojySNmITWQ08XUOIU";
        Jwt decode = JwtHelper.decode(token);
        System.out.println(decode);

    }

}
