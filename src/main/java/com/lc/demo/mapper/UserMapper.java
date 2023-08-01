package com.lc.demo.mapper;

import com.lc.demo.bean.User;
import org.apache.ibatis.annotations.*;

import javax.validation.constraints.Size;

@Mapper
public interface UserMapper {


//登陆    private int userId;
//    private String userAccount;
//    @Size(min=1,max = 10,message = "名字长度必须在1-10之间")
//    private String userPassword;
//    private String userName;
//    private String userNumber;
//    private int userSex;
//    @Size(min = 11,max = 11,message = "请输入11位手机号码")
//    private String userTele;
//    private String userpost;
//
//    private int loginStatus;
//    private int roleId;
    @Select("select * from user where account = #{userAccount} and password = #{userPassword}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userAccount", column = "account"),
            @Result(property = "userPassword", column = "password"),
            @Result(property = "userName", column = "name"),
            @Result(property = "userNumber", column = "student_number"),
            @Result(property = "userSex", column = "sex"),
            @Result(property = "userTele", column = "phone"),
            @Result(property = "userpost", column = "post"),
            @Result(property = "loginStatus", column = "login_status"),
            @Result(property = "roleId", column = "role_id"),
            // 其他属性的映射
    })
    User selectUserByAccountAndPassword(@Param("userAccount") String userAccount,@Param("userPassword") String userPassword);
//注册
    @Insert("insert into user(account,password,name,student_number,sex,phone,post,role_id) values(#{userAccount}," +
            "#{userPassword},#{userName},#{userNumber},#{userSex},#{userTele},#{userpost},1)")
    int insertUser(User user);

//账号查找
    @Select("select * from user where account = #{userAccount}")
    User selectUserByAccount(String userAccount);

    @Select("select * from user where student_number = #{userNumber}")
    User selectUserByNumber(String userNumber);

    @Insert("insert into user(user_id,account,password) values(#{userId},#{userAccount},#{userPassword})")
    int abc(int id,String account,String password);




}
