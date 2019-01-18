package com.example.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fescar.core.context.RootContext;
import com.example.test.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

//import com.alibaba.fescar.core.context.RootContext;

/**
 * @author 侯存路
 * @date 2019/1/11
 * @company codingApi
 * @description
 */
@Service(interfaceClass = PayService.class)
@Component
public class PayServiceImpl implements PayService {


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    @Transactional
    public String addPay(String userName) {
        System.out.println("----->"+ RootContext.getXID());

        jdbcTemplate.update("INSERT INTO `t_pay` (  `user_name` ) VALUES ( ? ) ; " , userName );

        return "123";
    }


}
