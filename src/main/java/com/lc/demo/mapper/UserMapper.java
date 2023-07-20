package com.lc.demo.mapper;

import com.lc.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.validation.constraints.Size;

@Mapper
public interface UserMapper {

    @Select("select * from user where account = #{userAccount} and password = #{userPassword)")
    User selectUserByAccountAndPassword(@Param("userAccount") String userAccount,@Param("userPassword") String userPassword);

    @Insert("insert into user(user_id,account,password,name,student_number,sex,phone,post) values(#{userId},#{userAccount}," +
            "#{userPassword},#{userName},#{userNumber},#{userSex},#{userTele},#{userpost})")
    int insertUser(User user);

    @Select("select * from user where account = #{userAccount}")
    User selectUserByAccount(String userAccount);

    @Insert("insert into user(user_id,account,password) values(#{userId},#{userAccount},#{userPassword})")
    int abc(int id,String account,String password);




}
