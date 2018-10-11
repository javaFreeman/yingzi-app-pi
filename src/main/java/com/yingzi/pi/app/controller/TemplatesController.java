package com.yingzi.pi.app.controller;

/**
 * @program: demo
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-11 15:59
 **/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class TemplatesController {

    @GetMapping("/templates")
    String test(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hello world");
        return "/index";
    }

    @GetMapping("post")
    public String helloHtml(HashMap<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面");
        return "/index";
    }
}
