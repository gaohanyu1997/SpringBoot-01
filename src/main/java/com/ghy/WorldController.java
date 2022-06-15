package com.ghy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {
    @RequestMapping("/world")
    public String world(){
        return "world";
    }
}
