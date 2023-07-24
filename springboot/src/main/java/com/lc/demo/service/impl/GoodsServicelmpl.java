package com.lc.demo.service.impl;

import com.lc.demo.bean.Goods;
import com.lc.demo.mapper.GoodsMapper;
import com.lc.demo.mapper.UserMapper;
import com.lc.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 22932
 */
@Service
public class GoodsServicelmpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.selectAllGoods();
    }

    @Override
    public List<Goods> selectGoodsByGoodsName(String goodsName) {
        return goodsMapper.selectGoodsByGoodsName(goodsName);
    }

    @Override
    public Goods selectGoodsById(int goodsId) {
        return goodsMapper.selectGoodsById(goodsId);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int deleteGoods(int goodsId) {
        return goodsMapper.deleteGoodsById(goodsId);
    }
}
