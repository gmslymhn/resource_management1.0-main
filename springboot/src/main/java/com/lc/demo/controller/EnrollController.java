package com.lc.demo.controller;


import com.lc.demo.bean.User;
import com.lc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")//参数映射 必须传递
    public String register(User user) {
        System.out.println(user);
        if(userService.selectByAccount(user.getUserAccount())!=null){
            System.out.println("账号已存在");
        }else{
            if(userService.selectByNumer(user.getUserNumber())!=null){
                System.out.println("学号已存在");
            }
            else{
                userService.addUser(user);
                return "redirect:/login";
            }
        }
            return  "register";


    }



}
