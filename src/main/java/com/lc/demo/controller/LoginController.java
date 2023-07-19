package com.lc.demo.controller;


import com.lc.demo.bean.*;
import com.lc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/adm/login")
    public String login(@RequestParam("userAccount") String userAccount,
                        @RequestParam("userPassword") String userPassword, Map<String,Object> map, HttpSession session)
    {
        User adm=userService.adminLogin(userAccount,userPassword);
        if(adm!=null)
        {
//            List<Classes> classes=classService.getAllClass();
//            session.setAttribute("loginUser",username);
            return "redirect:/admmain.html";
        }
        else
        {
            map.put("msg","用户名或密码错误");
            return  "login";
        }
    }

}
