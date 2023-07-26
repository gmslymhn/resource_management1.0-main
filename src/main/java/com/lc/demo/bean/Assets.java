package com.lc.demo.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

public class Assets {
private  int id;
    private float totalAssets;
    private float disposableAssets;

    private DateTimeLiteralExpression.DateTime time;

    public Assets() {
    }

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

    @Override
    public String toString() {
        return "Assets{" +
                "id=" + id +
                ", totalAssets=" + totalAssets +
                ", disposableAssets=" + disposableAssets +
                ", time=" + time +
                '}';
    }

    public Assets(int id, float totalAssets, float disposableAssets, DateTimeLiteralExpression.DateTime time) {
        this.id = id;
        this.totalAssets = totalAssets;
        this.disposableAssets = disposableAssets;
        this.time = time;
    }

}
