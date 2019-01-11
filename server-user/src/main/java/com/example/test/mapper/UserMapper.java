package com.example.test.mapper;

import com.example.test.model.User;
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
public interface UserMapper {



    @Insert(" INSERT INTO `t_user` (  `user_name`, `create_time`) VALUES ( #{user.userName} , #{user.createTime} ) ; ")
    void savePay(@Param("user") User user);


}
