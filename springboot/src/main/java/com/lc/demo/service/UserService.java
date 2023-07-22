package com.lc.demo.service;

import com.lc.demo.bean.User;
public interface UserService {

    //登录
    User Login(String userAccount, String userPassword);



    //通过账号查找
    User selectByAccount(String userAccount);

    User selectByNumer(String userNumber);

    //添加用户
    int addUser(User user);
}
