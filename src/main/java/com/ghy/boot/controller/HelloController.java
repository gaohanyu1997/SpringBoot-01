package com.ghy.boot.controller;
import com.ghy.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.smartcardio.Card;

/*@Controller
@ResponseBody*/
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car card(){
        return car;
    }

    @RequestMapping("/hello")
    public String hello(){
        log.info("请求进来了....");
        return "hello,开启springboot2学习之旅!";
    }

}
