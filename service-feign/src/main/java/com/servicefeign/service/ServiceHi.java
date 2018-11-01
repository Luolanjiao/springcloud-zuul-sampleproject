package com.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Thinkpad on 2018/10/29.
 */
@FeignClient(value = "service-hi",fallback = HiHystric.class)
public interface ServiceHi {
    @RequestMapping(value="/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value="name") String name);
}
