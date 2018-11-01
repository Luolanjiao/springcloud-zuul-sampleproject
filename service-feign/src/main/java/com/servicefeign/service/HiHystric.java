package com.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * Created by Thinkpad on 2018/10/29.
 */
@Component
public class HiHystric implements ServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "短路器返回的";
    }
}
