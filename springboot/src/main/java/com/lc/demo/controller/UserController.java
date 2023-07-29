package com.lc.demo.controller;
import com.lc.demo.bean.User;
import com.lc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * @author gmslymhn
 * @date 2023-07-26 18:35
 * @description:注册登录
 */

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestParam("useraccount") String useraccount,
                        @RequestParam("password") String password, Map<String,Object> map, HttpSession session) {
        System.out.println(useraccount);
        System.out.println(password);
        User user = userService.Login(useraccount,password);
        System.out.println(user);
        if(user!=null)
        {
            if (user.getRoleId()==1){
                return "redirect:admin/adminindex";
            }
            else{
                return "redirect:user/userindex";
            }
        }
        else
        {
            map.put("msg","用户名或密码错误");
            return  "login";
        }

    }
    @PostMapping(value = "/register")//参数映射 必须传
    public String register(User user){

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
        return  "/register";

    }


    }