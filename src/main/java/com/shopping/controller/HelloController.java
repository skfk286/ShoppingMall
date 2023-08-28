package com.shopping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Sample Controller")
public class HelloController {
    
    
    @GetMapping("/hello")
    @ApiOperation("Get a greeting message")
    public String hello(@ApiParam(value = "Name") @RequestParam String name) {
        return "Hello, " + name + "!";
    }
}
