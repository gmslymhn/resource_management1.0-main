package com.lc.demo.service.impl;

import com.lc.demo.bean.Goods;
import com.lc.demo.service.GoodsService;

import java.util.List;

public class GoodsServicelmpl implements GoodsService {
    @Override
    public List<Goods> getAllGoods() {
        return null;
    }

    @Override
    public List<Goods> selectGoogByGoodsName(String goodsName) {
        return null;
    }

    @Override
    public List<Goods> selectGoodsByGoodsId(Integer goodsId) {
        return null;
    }

    @Override
    public Goods selectGoodsById(int goodsId) {
        return null;
    }

    @Override
    public Goods selectGoodsByName(String goodName) {
        return null;
    }

    @Override
    public int addGoods(Goods goods) {
        return 0;
    }

    @Override
    public int updateGoods(Goods goods) {
        return 0;
    }

    @Override
    public int deleteGoods(int goodsId) {
        return 0;
    }
}
