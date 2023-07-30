package com.lc.demo.service.impl;
import com.lc.demo.bean.User;
import com.lc.demo.mapper.UserMapper;
import com.lc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServicelmpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User Login(String userAccount,String userPassword){
        return userMapper.selectUserByAccountAndPassword(userAccount,userPassword);
    }



    @Override
    public User selectByAccount(String userAccount) {
        return userMapper.selectUserByAccount(userAccount);
    }

    @Override
    public User selectByNumer(String userNumber) {
        return userMapper.selectUserByNumber(userNumber);
    }

    @Override
    public int addUser(User user) {
            return userMapper.insertUser(user);
    }


}
