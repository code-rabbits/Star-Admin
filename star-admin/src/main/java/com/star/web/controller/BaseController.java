package com.star.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 该控制器的作用是跳转页面路径
 */
@Controller
public class BaseController {

    /**
     * 去到后台首页
     * @return
     */
    @RequestMapping("/index")
    public String Index(){
        return "index";
    }

    @RequestMapping("/main")
    public String Main(){
        return "main";
    }
}
