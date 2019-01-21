package com.example.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fescar.core.context.RootContext;
import com.example.test.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


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
    @Transactional(rollbackFor = Exception.class)
    public String addPay(String userName) {
        System.out.println("----->"+ RootContext.getXID());

        jdbcTemplate.update("UPDATE  `t_pay` SET  `user_name` = 'pay' WHERE `id` = 1 "  );

        return "123";
    }


}
