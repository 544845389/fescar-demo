package com.example.pay.service.impl;

import com.example.pay.mapper.PayMapper;
import com.example.pay.model.Pay;
import com.example.pay.service.PayService;
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
public class PayServiceImpl implements PayService {


    @Autowired
    private PayMapper  payMapper;



    @Override
    public String addPay(String userName) {
        Pay pay = new Pay();
        pay.setUserName(userName);
        pay.setCreateTime(new Date());
        payMapper.savePay(pay);
        return "123";
    }


}
