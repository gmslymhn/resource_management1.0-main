package com.lc.demo.service;

import com.lc.demo.bean.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods>  getAllGoods();


    List<Goods> selectGoogByGoodsName(String goodsName);


    List<Goods> selectGoodsByGoodsId(Integer goodsId);

    Goods selectGoodsById(int goodsId);

    Goods selectGoodsByName(String goodName);

    int addGoods(Goods goods);
    int updateGoods(Goods goods);
    int deleteGoods(int goodsId);

}
