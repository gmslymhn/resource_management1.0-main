package com.lc.demo.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

public class Assets_Log {

    private  int assetsLogId;

    private String userName;
    private String description;
    private float changeAssets;
    private DateTimeLiteralExpression.DateTime processTime;
    private float beforeAssets;
    private float afterAssets;


    public Assets_Log() {
    }

    public Assets_Log(int assetsLogId, String userName, String description, float changeAssets, DateTimeLiteralExpression.DateTime processTime, float beforeAssets, float afterAssets) {
        this.assetsLogId = assetsLogId;
        this.userName = userName;
        this.description = description;
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


    public String getDascription() {
        return description;
    }

    public void setDascription(String description) {
        this.description = description;
    }


    public float getChangeAssets() {
        return changeAssets;
    }

    public void setChangeAssets(float changeAssets) {
        this.changeAssets = changeAssets;
    }


    public DateTimeLiteralExpression.DateTime getProcessTime() {
        return processTime;
    }

    public void setProcessTime(DateTimeLiteralExpression.DateTime processTime) {
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
                ", description='" + description + '\'' +
                ", changeAssets=" + changeAssets +
                ", processTime=" + processTime +
                ", beforeAssets=" + beforeAssets +
                ", afterAssets=" + afterAssets +
                '}';
    }
}
