package com.lc.demo.controller;


import com.lc.demo.bean.*;
import com.lc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;



    @GetMapping("/")
    public int main(User user) {
        user.setUserAccount("123");
        user.setUserPassword("XXX");
        user.setUserName("XXX");
        user.setUserSex(Integer.parseInt("123"));
        user.setUserNumber("2022005744");
        user.setUserpost("3213");
        user.setUserTele("33213");

        System.out.println(user);

        int i = userService.addUser(user);

        return  i;
    }

    @PostMapping
    public Integer save(@RequestBody User user){
        return userService.addUser(user);
    }

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


