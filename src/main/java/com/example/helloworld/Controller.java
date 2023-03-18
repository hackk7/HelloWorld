package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 马克
 * @date 2022/12/19
 */
@RestController
public class Controller {
    @GetMapping("hello")
    public String sayHello() {
        return "Hello World~~";
    }
}
