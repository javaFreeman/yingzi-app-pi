package com.yingzi.pi.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: demo
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-11 15:53
 **/

@Controller
public class HelloController {
    @GetMapping("/html")
    public String html() {
        return "/index.html";
    }
}
