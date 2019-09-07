package com.mybatis.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 17715
 */
@Controller
public class PageContoller {
    @RequestMapping("/login")
    public String login(){
        System.out.println("你好，你已经访问到我了");
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
}
