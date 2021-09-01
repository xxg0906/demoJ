package top.xxgo.common.mysql.entity;

import lombok.Data;

import java.util.Optional;

@Data
public class Hello {

    public Hello setName(String name) {
        this.name = name;
        return  this;
    }

    String  name;

    public Hello(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        Hello hello=null;

        Optional.ofNullable(hello)
                .map(h->h.getName())
                .map(name->hello.setName(name))
                .orElse(new Hello("Tony"));


        Optional.ofNullable(hello)
                .map(h->h.getName())
                .map(name->hello.setName(name))
                .orElse(new Hello("Tony"));


    }
}
