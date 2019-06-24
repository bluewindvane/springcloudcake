package com.yxf.eurekaservice.controller;

import com.netflix.discovery.converters.Auto;
import com.yxf.eurekaservice.feign.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/feign")
public class FeignCotroller {

    @Autowired
    private EurekaClientFeign eurekaClientFeign;

    @GetMapping("/getPersonInfo")
    private String getPersonInfo(){
       String result =  eurekaClientFeign.getPersonList();

       return result;
    }

}
