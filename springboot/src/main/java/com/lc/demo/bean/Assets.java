package com.lc.demo.bean;

public class Assets {

    private float totalAssets;
    private float disposableAssets;

    public Assets() {
    }

    public Assets(float totalAssets, float disposableAssets) {
        this.totalAssets = totalAssets;
        this.disposableAssets = disposableAssets;
    }
    public float getTotalAssets() {
        return totalAssets;
    }
    public void setTotalAssets(float totalAssets) {
        this.totalAssets = totalAssets;
    }
    public float getDisposableAssets(){
        return disposableAssets;
    }
    public void setDisposableAssets(float disposableAssets) {
        this.disposableAssets = disposableAssets;
    }
    @Override
    public String toString() {
        return "Assets{" +
                "totalAssets=" + totalAssets +'\'' +
                ", disposableAssets=" + disposableAssets +'\'' +
                '}';
    }



}
