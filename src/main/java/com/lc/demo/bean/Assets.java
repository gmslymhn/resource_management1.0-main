package com.lc.demo.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

public class Assets {

    private Float  totalAssets;
    private Float  disposableAssets;

    private Date time;
    private Integer   id;

    private String description;
    private Float  percentage;


    public Assets() {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Float totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Float getDisposableAssets() {
        return disposableAssets;
    }

    public void setDisposableAssets(Float disposableAssets) {
        this.disposableAssets = disposableAssets;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Assets(Integer id, Float totalAssets, Float disposableAssets, Date time, Float percentage, String description) {
        this.id = id;
        this.totalAssets = totalAssets;
        this.disposableAssets = disposableAssets;
        this.time = time;
        this.percentage = percentage;
        this.description = description;
    }
}
