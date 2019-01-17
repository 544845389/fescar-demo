package com.example.test.mapper;

import com.example.test.model.Pay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 侯存路
 * @date 2019/1/11
 * @company codingApi
 * @description
 */
@Mapper
public interface PayMapper {



    @Insert(" INSERT INTO `t_pay` (  `user_name`, `create_time`) VALUES ( #{pay.userName} , #{pay.createTime} ) ; ")
    void savePay(@Param("pay") Pay pay);


}
