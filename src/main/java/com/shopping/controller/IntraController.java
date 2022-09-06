package com.shopping.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IntraController {
    
    private final Logger logger = LogManager.getLogger(this.getClass());
        
    //test용
    @RequestMapping(value = "/mall/init.do", method = RequestMethod.GET)
    public String init() {
        
        return "/index";
    }
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String intra() {
        //ObjectUtils.isEmpty("a");
        
        return "redirect:/app/home";
    }
    
    @RequestMapping(value = "/app/home", method = RequestMethod.GET)
    public String app() {
        //ObjectUtils.isEmpty("a");
        
        return "/app/home";
    }
    
    
    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public String login() {
        
        return "/auth/login";
    }
}
