package com.soff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IntraController {
    
    @RequestMapping(value = "/mall/init.do", method = RequestMethod.GET)
    public void init() {
        
        System.out.println("ok.....");
    }
}
