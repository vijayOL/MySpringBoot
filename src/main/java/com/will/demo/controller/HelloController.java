package com.will.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @see: demo
 * @Date 2018/1/24 15:07
 * @Author Vijay Tang
 */
@RestController
public class HelloController {

    @GetMapping(value="/hello")
    public String hello(@RequestParam("name")String name,@RequestParam("date")String date){
        return "Hello SpringBoot,I am coming!"+name+",date:"+date;
    }
}
