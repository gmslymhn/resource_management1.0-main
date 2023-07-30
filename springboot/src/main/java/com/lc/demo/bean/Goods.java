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

    public Goods(String goodsName, int goodsId, String goodsstate, String goodsImage) {
        this.goodsName = goodsName;
        this.goodsId = goodsId;
        this.goodsState = goodsstate;
        this.goodsImage = goodsImage;
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

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
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

