package com.lc.demo.service.impl;
import com.lc.demo.bean.User;
import com.lc.demo.mapper.UserMapper;
import com.lc.demo.service.UserService;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
@Service
public class UserServicelmpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public String Encrypt(String userPassword){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(userPassword.getBytes("utf-8"));
            byte[] digest = md.digest();
            return String.valueOf(Hex.encodeHex(digest));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //SHA1算法加密 不可逆
    @Override
    public User Login(String userAccount,String userPassword) {
        String userPassword1= Encrypt(userPassword);
        return userMapper.selectUserByAccountAndPassword(userAccount, userPassword1);
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
            user.setUserPassword(Encrypt(user.getUserPassword()));
        return userMapper.insertUser(user);
    }

}
