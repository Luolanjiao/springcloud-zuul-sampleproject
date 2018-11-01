package com.servicefeign.controller;

import com.servicefeign.service.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Thinkpad on 2018/10/29.
 */
@RestController
public class HiController {
    @Autowired
    ServiceHi serviceHi;

    @RequestMapping(value = "hi")
    public String hi(@RequestParam(value = "name") String name)
    {
        return serviceHi.sayHiFromClientOne(name);
    }
}
