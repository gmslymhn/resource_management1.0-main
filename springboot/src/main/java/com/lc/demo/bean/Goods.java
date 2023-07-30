package com.lc.demo.bean;

import junit.framework.Test;

public class Goods {
    private String goodsName;
    private int goodsId;
    private String goodsstate;
    private String goodslmage;

    public Goods() {
    }

    public Goods(String goodsName, int goodsId, String goodsstate, String goodslmage) {
        this.goodsName = goodsName;
        this.goodsId = goodsId;
        this.goodsstate = goodsstate;
        this.goodslmage = goodslmage;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
    public String getGoodsstate() {
        return goodsstate;
    }

    public void setGoodsstate(String goodsstate) {
        this.goodsstate = goodsstate;
    }

    public String getGoodslmage() {
        return goodslmage;
    }

    public void setGoodslmage(String goodslmage) {
        this.goodslmage = goodslmage;
    }
    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsId=" + goodsId +
                ", goodsstate='" + goodsstate + '\'' +
                ", goodslmage='" + goodslmage + '\'' +
                '}';
    }


}
