package com.ghy.boot.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*@Controller
@ResponseBody*/
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello,开启springboot2学习之旅!";
    }
}
