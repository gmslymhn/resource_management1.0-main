package com.lc.demo.bean;


import javax.validation.constraints.Size;

public class User {


    private int userId;
    private String userAccount;
    @Size(min=1,max = 10,message = "名字长度必须在1-10之间")
    private String userPassword;
    private String userName;
    private String userNumber;
    private int userSex;
    @Size(min = 11,max = 11,message = "请输入11位手机号码")
    private String userTele;
    private String userpost;

    private int loginStatus;
    private int roleId;


    public User() {
    }

    public User(int userId,String userName,String userAccount,String userPassword,String UserNumber,int userSex,String userTele,String userpost) {
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userNumber = UserNumber;
        this.userSex = userSex;
        this.userTele = userTele;
        this.userpost = userpost;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserNumber() {
        return userNumber;
    }
    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserpost() {
        return userpost;
    }

    public void setUserpost(String userpost) {
        this.userpost = userpost;
    }

    public String getUserTele() {
        return userTele;
    }

    public void setUserTele(String userTele) {
        this.userTele = userTele;
    }

    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public int getLoginStatus() {
        return loginStatus;
    }
    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }



    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userpost='" + userpost + '\'' +
                ", userTele='" + userTele + '\'' +
                ", loginStatus='" + loginStatus + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
