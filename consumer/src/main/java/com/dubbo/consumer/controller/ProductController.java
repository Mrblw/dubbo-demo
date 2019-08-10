package com.dubbo.consumer.controller;

import com.dubbo.consumer.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProductController
 * @Description
 * @Author buliwen
 * @Date 2019-08-10 11:55
 * @Version 1.0
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 添加完 返回总共消费
     * @param a
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping("/add")
    public String getCost(int a){
        return "该产品总共消费 ："+productService.getCost(a);
    }

    public String hiError(int a) {
        return a+"";
    }

}
