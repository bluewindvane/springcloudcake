package com.yxf.eurekaservice.feign;

import com.yxf.eurekaservice.feign.fallback.EurekaClientFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "EUREKA-CLIENT",fallback = EurekaClientFeignFallback.class)
public interface EurekaClientFeign {

    @GetMapping("/person/getPersonList")
    public String getPersonList();

}
