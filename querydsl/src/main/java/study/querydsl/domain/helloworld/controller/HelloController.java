package study.querydsl.domain.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hllo")
    public String hello(){
        return "hello";
    }
}