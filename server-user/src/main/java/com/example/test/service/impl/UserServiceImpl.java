package com.example.test.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.example.test.mapper.UserMapper;
import com.example.test.model.User;
import com.example.test.service.OrderService;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 侯存路
 * @date 2019/1/11
 * @company codingApi
 * @description
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Reference
    OrderService orderService;


    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-demo-tx")
    public String addUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        user.setCreateTime(new Date());
        userMapper.savePay(user);

        orderService.addOrder(userName);

        return "user";
    }



}
