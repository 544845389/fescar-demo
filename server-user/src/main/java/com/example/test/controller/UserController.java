package com.example.test.controller;

import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 侯存路
 * @date 2019/1/11
 * @company codingApi
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserService userService;


    @GetMapping("/addUser")
    public  String  addUser(@RequestParam("userName") String userName){
        return   userService.addUser(userName);
    }






}
