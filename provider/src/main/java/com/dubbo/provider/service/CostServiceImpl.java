package com.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.service.CostService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;

@Service
public class CostServiceImpl implements CostService {

    /**
     * 假设之前总花费了100
     */
    private final Integer totalCost = 1000;

    @Value("${server.port}")
    private Integer port;

    /**
     * 之前总和 加上 最近一笔
     * @param cost
     * @return
     */
    @HystrixCommand(commandProperties = {
            //请求量
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //请求超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @Override
    public Integer add(int cost) {
        /*return totalCost + cost;*/
        return port;
    }
}