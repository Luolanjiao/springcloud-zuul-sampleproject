package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Thinkpad on 2018/10/24.
 */
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

   // @RequestMapping("hello")
   @GetMapping(value = "/hi")
    public String Hello(){
       return helloService.hiService();
    }
}
