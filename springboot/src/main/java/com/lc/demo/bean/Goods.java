package com.lc.demo.bean;



/**
 * @author: 22932
 */

public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String goodsState;
    private String goodsImage;

    public Goods() {
    }

    public Goods(String goodsName, int goodsId, String goodsstate, String goodslmage) {
        this.goodsName = goodsName;
        this.goodsId = goodsId;
        this.goodsState = goodsstate;
        this.goodsImage = goodslmage;
    }


    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }


    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsstate) {
        this.goodsState = goodsstate;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodslmage) {
        this.goodsImage = goodslmage;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsState='" + goodsState + '\'' +
                ", goodsImage='" + goodsImage + '\'' +
                '}';
    }
}

