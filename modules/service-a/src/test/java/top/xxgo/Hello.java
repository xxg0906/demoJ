package top.xxgo;


import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class Hello {

    public Hello setName(String name) {
        this.name = name;
        return  this;
    }

     public String getName() {
         return name;
     }

     String  name;

    String address;

    public Hello(String name,String address) {
        this.name = name;
    }

    public Hello() {
    }

    @Override
     public String toString() {
         return "Hello{" +
                 "name='" + name + '\'' +
                 '}';
     }

     public static void main(String[] args) {
//         Hello hello = null;
//         Function<String, Hello> function1 = name -> hello.setName(name);
//         Hello hello2 = null;
//         Function<String, Hello> function2 = hello2::setName;
//         Hello s = Optional.ofNullable(hello)
//                 .map(Hello::getName)
//                 .map(function1)
//                 .orElse(new Hello("s", ""));
         Map<String, String> map = new HashMap<>();
         map.put("ss","sss");
         map.computeIfAbsent("ss",key->{
             System.out.println(key);
             return key;

         });
         System.out.println(map);


     }




}
