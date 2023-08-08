package com.lc.demo.controller;
import com.lc.demo.bean.User;
import com.lc.demo.service.UserService;
import common.Result;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


import java.security.MessageDigest;
import java.util.Map;

/**
 * @author gmslymhn
 * @date 2023-07-26 18:35
 * @description:注册登录
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/abc/login")
    public Result<Map<String,String>> login(@RequestParam("useraccount") String useraccount,
                                @RequestParam("password") String password, Map<String,String> map, HttpSession session) {
        User user = userService.Login(useraccount,password);
        System.out.println(user);
        if(user!=null) {
            String token = null;
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                md.update(user.getUserAccount().getBytes("utf-8"));
                byte[] digest = md.digest();
                token = String.valueOf(Hex.encodeHex(digest));
                map.put("account",user.getUserAccount());
                map.put("id", String.valueOf(user.getUserId()));
                map.put("name",user.getUserName());
                map.put("token",token);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            if (user.getRoleId() == 2) {
                session.setAttribute("loginUser", useraccount);
                session.setAttribute("User", "admin");
                return Result.success(map, "admin");
            } else {
                session.setAttribute("User", "admin");
                return Result.success(map, "user");
            }
        }
        else
        {
            return Result.error("用户名或密码错误");
        }
    }

    @PostMapping(value = "/abc/register")//参数映射 必须传
    public Result<User> register(@RequestBody User user, Map<String,Object> map, HttpSession session){

        System.out.println(user);
        if(userService.selectByAccount(user.getUserAccount())!=null){
            return Result.error("账号已存在");
        }else{
            if(userService.selectByNumer(user.getUserNumber())!=null){
                return Result.error("学号已存在");
            }
            else{
                userService.addUser(user);
                return Result.success(user,"user");
            }
        }

    }
    @RequestMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/index.html";
    }

    @GetMapping(value = "/adm/toindex")
    public String toadmindex(){
        return "redirect:/admmain.html";
    }

    @GetMapping(value = "/user/toindex")
    public String touserindex(){
        return "redirect:/usermain.html";
    }


    }