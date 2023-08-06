package com.lc.demo.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

public class Assets_Log {

    private  int assetsLogId;

    private String userName;
    private String description;
    private float changeAssets;
    private Date processTime;
    private float beforeAssets;
    private float afterAssets;


    public Assets_Log() {
    }

    public Assets_Log(int assetsLogId, String userName, String dascription, float changeAssets, Date processTime, float beforeAssets, float afterAssets) {
        this.assetsLogId = assetsLogId;
        this.userName = userName;
        this.description = dascription;
        this.changeAssets = changeAssets;
        this.processTime = processTime;
        this.beforeAssets = beforeAssets;
        this.afterAssets = afterAssets;
    }
    public int getAssetsLogId() {
        return assetsLogId;
    }
    public void setAssetsLogId(int assetsLogId) {
        this.assetsLogId = assetsLogId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String dascription) {
        this.description = dascription;
    }


    public float getChangeAssets() {
        return changeAssets;
    }

    public void setChangeAssets(float changeAssets) {
        this.changeAssets = changeAssets;
    }


    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }


    public float getBeforeAssets() {
        return beforeAssets;
    }

    public void setBeforeAssets(float beforeAssets) {
        this.beforeAssets = beforeAssets;
    }


    public float getAfterAssets() {
        return afterAssets;
    }

    public void setAfterAssets(float afterAssets) {
        this.afterAssets = afterAssets;
    }
    @Override
    public String toString() {
        return "Assets_Log{" +
                "userName='" + userName + '\'' +
                ", dascription='" + description + '\'' +
                ", changeAssets=" + changeAssets +
                ", processTime=" + processTime +
                ", beforeAssets=" + beforeAssets +
                ", afterAssets=" + afterAssets +
                '}';
    }
}
