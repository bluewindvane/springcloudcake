package com.yxf.eurekaservice.feign.fallback;

import com.yxf.eurekaservice.feign.EurekaClientFeign;
import org.springframework.stereotype.Component;

@Component
public class EurekaClientFeignFallback implements EurekaClientFeign {

    @Override
    public String getPersonList() {
        return "获取人员接口服务出现错误！";
    }
}
