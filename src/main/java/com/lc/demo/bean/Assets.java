package com.lc.demo.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

public class Assets {
    private int id;
    private float totalAssets;
    private float disposableAssets;

    private DateTimeLiteralExpression.DateTime time;
    private float percentage;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(float totalAssets) {
        this.totalAssets = totalAssets;
    }

    public float getDisposableAssets() {
        return disposableAssets;
    }

    public void setDisposableAssets(float disposableAssets) {
        this.disposableAssets = disposableAssets;
    }

    public DateTimeLiteralExpression.DateTime getTime() {
        return time;
    }

    public void setTime(DateTimeLiteralExpression.DateTime time) {
        this.time = time;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Assets{" +
                "id=" + id +
                ", totalAssets=" + totalAssets +
                ", disposableAssets=" + disposableAssets +
                ", time=" + time +
                ", percentage=" + percentage +
                ", description='" + description + '\'' +
                '}';
    }

    public Assets(int id, float totalAssets, float disposableAssets, DateTimeLiteralExpression.DateTime time, float percentage, String description) {
        this.id = id;
        this.totalAssets = totalAssets;
        this.disposableAssets = disposableAssets;
        this.time = time;
        this.percentage = percentage;
        this.description = description;
    }
}
