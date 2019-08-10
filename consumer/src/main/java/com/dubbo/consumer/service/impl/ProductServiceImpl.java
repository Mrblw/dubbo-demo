package com.dubbo.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.api.service.CostService;
import com.dubbo.consumer.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProductServiceImpl
 * @Description
 * @Author buliwen
 * @Date 2019-08-10 11:53
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Reference
    private CostService costService;

    @Override
    public Integer getCost(int a) {
        return costService.add(a);
    }
}
