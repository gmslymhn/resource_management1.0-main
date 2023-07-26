package com.lc.demo.controller;


import com.lc.demo.bean.*;
import com.lc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/login")//参数映射 必须传递
    public String login(@RequestParam("useraccount") String useraccount,
                        @RequestParam("password") String password,Map<String,Object> map, HttpSession session) {
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

//    @PostMapping
//    public int save(@RequestParam("username") String username,
//                        @RequestParam("password") String password){
//        User user = new User();
//        user.setUserAccount(username);
//        user.setUserPassword(password);
//        user.setUserName("XXX");
//        user.setUserSex(Integer.parseInt("123"));
//        user.setUserNumber("2022005744");
//        user.setUserpost("3213");
//        user.setUserTele("33213");
//
//        System.out.println(user);
//
//
//
//        return  i;
//    }

//
//    @PostMapping(value = "login")
//    public String login(@RequestParam("userAccount") String userAccount,
//                        @RequestParam("userPassword") String userPassword, Map<String,Object> map, HttpSession session)
//    {
//        User adm=userService.adminLogin(userAccount,userPassword);
//        if(adm!=null)
//        {
////            List<Classes> classes=classService.getAllClass();
////            session.setAttribute("loginUser",username);
//            return "redirect:/admmain.html";
//        }
//        else
//        {
//            map.put("msg","用户名或密码错误");
//            return  "login";
//        }
//    }

}


