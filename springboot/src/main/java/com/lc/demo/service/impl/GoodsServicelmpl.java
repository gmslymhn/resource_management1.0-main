package com.lc.demo.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Goods;
import com.lc.demo.mapper.GoodsMapper;
import com.lc.demo.service.GoodsService;
import com.lc.demo.utils.GoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
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
    public GoodsResult getAllGoods(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsMapper.selectAllGoods());
        return GoodsResult.pagingGoodsResult(pageSize,pageInfo);
    }
    @Override
    public List<Goods> selectGoodsByGoodsName(String goodsName) {
        return goodsMapper.selectGoodsByGoodsName(goodsName);
    }
    @Override
    public Goods selectGoodsById(int goodsId) {
        return goodsMapper.selectGoodsById(goodsId);
    }
    public GoodsResult selectGoodsByGoodsName(int pageNum, int pageSize, String goodsName) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsMapper.selectGoodsByGoodsName(goodsName));
        return  GoodsResult.pagingGoodsResult(pageSize,pageInfo);
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
