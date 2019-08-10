package com.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**  
 * @Author <bu.liwen@chinaott.net>
 * @Description 
 * @Date 2019-08-10 12:06
 */
@SpringBootApplication
@EnableDubbo
@EnableHystrix
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
