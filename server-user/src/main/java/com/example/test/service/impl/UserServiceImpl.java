package com.example.test.service.impl;



import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.example.test.service.OrderService;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author 侯存路
 * @date 2019/1/11
 * @company codingApi
 * @description
 */
@Service
public class UserServiceImpl implements UserService {


    @Reference
    OrderService orderService;


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-demo-tx")
    @Transactional
    public String addUser(String userName) {
        System.out.println("----->"+ RootContext.getXID());

        jdbcTemplate.update("INSERT INTO `t_user` (  `user_name` ) VALUES ( ? ) ; " , userName  );


        orderService.addOrder(userName);

        return "user";
    }



}
