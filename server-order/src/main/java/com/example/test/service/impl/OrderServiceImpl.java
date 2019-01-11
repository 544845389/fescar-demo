package com.example.test.service.impl;

import com.example.test.mapper.OrderMapper;
import com.example.test.model.Order;
import com.example.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * @author 侯存路
 * @date 2019/1/11
 * @company codingApi
 * @description
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderMapper  orderMapper;


    @Override
    public boolean addOrder(String userName) {
        Order  order = new Order();
        order.setCreateTime(new Date());
        order.setUserName(userName);
        orderMapper.saveOrder(order);

        if(ObjectUtils.isEmpty(userName)){
            throw  new NullPointerException("用户名称为空");
        }
        return true;
    }



}
