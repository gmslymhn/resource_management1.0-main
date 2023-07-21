package com.lc.demo.service;

import com.lc.demo.bean.User;
public interface UserService {

    //管理登录
    User adminLogin(String userAccount, String userPassword);


    //用户登陆
    User userLogin(String userAccount, String userPassword);

    //通过账号查找
    User selectByAccount(String userAccount);

    //添加用户
    int addUser(User user);
}
