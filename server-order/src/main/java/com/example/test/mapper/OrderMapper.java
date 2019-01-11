package com.example.test.mapper;

import com.example.test.model.Order;
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
public interface OrderMapper {



    @Insert(" INSERT INTO `t_order` (  `user_name`, `create_time`) VALUES ( #{order.userName} , #{order.createTime} ) ; ")
    void saveOrder(@Param("order") Order order);


}
