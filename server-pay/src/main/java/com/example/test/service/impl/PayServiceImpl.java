package com.example.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fescar.core.context.RootContext;
import com.example.test.mapper.PayMapper;
import com.example.test.model.Pay;
import com.example.test.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

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
    private PayMapper  payMapper;


    @Override
    @Transactional
    public String addPay(String userName) {
        System.out.println("----->"+RootContext.getXID());
        Pay pay = new Pay();
        pay.setUserName(userName);
        pay.setCreateTime(new Date());
        payMapper.savePay(pay);

        return "123";
    }


}
