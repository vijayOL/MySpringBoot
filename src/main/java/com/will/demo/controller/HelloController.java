package com.will.demo.controller;

import com.will.demo.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @see: demo
 * @Date 2018/1/24 15:07
 * @Author Vijay Tang
 */
@RestController
public class HelloController {

    @Autowired
    private Person person;

    @GetMapping(value="/hello")
    public String hello(@RequestParam("name")String name,@RequestParam("date")String date){
        return "Hello SpringBoot,I am coming!"+name+",date:"+date;
    }

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @Value("${content}")
    private String content;

    @GetMapping(value ="/hi")
    public String say(){
        return "name:"+name+",age:"+age;
    }

    @GetMapping(value ="/print")
    public String print(){
        return "name:"+person.getName()+",age:"+person.getAge();
    }

    @GetMapping(value ="/printContent")
    public String printContent(){
        return content;
    }

}
