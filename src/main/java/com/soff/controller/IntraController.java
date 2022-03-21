package com.soff.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IntraController {
    
    private final static Logger logger = LogManager.getLogger(IntraController.class);
    
    @RequestMapping(value = "/mall/init.do", method = RequestMethod.GET)
    public String init() {
        
        System.out.println("ok....ddd.");
        
        return "index";
    }
}
