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

    @PostMapping(value = "/abc/login")
    public String login(@RequestParam("useraccount") String useraccount,
                        @RequestParam("password") String password, Map<String,Object> map, HttpSession session) {
        User user = userService.Login(useraccount,password);
        System.out.println(user);
        if(user!=null)
        {
            if (user.getRoleId()==2){
                session.setAttribute("loginUser",useraccount);
                return "redirect:/admin/adminindex";
            }
            else{
                session.setAttribute("loginUser",useraccount);
                return "redirect:/user/userindex";
            }
        }
        else
        {
            map.put("msg","用户名或密码错误");
            return  "login";
        }
    }

    @PostMapping(value = "/abc/register")//参数映射 必须传
    public String register(@RequestParam("useraccount") String useraccount,
                           @RequestParam("password") String password,
                           @RequestParam("username") String username,
                           @RequestParam("usernumber") String usernumber,
                           @RequestParam("userpost") String userpost,Map<String,Object> map, HttpSession session){
        User user = new User();
        user.setUserNumber(usernumber);
        user.setUserpost(userpost);
        user.setUserAccount(useraccount);
        user.setUserPassword(password);
        user.setUserName(username);

        System.out.println(user);
        if(userService.selectByAccount(user.getUserAccount())!=null){
            map.put("msg","账号已存在");
        }else{
            if(userService.selectByNumer(user.getUserNumber())!=null){
                map.put("msg","学号已存在");
            }
            else{
                userService.addUser(user);
                return "redirect:/login";
            }
        }
        return  "/register";

    }


    }