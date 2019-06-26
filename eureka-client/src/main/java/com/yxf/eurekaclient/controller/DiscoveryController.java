package com.yxf.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String ip;

    @Value("${yxf}")
    private String myname;

    @GetMapping("/client")
    public String client() {
        String services = "Services: " + discoveryClient.getServices()+" ip :"+ip+"   name: "+myname;

        System.out.println(services);
        return services;
    }
}
