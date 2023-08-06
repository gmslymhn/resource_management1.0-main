package com.lc.demo.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Goods;
import com.lc.demo.mapper.GoodsMapper;
import com.lc.demo.service.GoodsService;
import common.GoodsResult;
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
    public GoodsResult getAllGoods(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsMapper.selectAllGoods());
        if(pageInfo.getTotal() != 0) {
            return  GoodsResult.pagingGoodsResult(pageNum,pageSize,pageInfo);
        }else{
            return null;
        }
    }


    @Override
    public GoodsResult selectGoodsByGoodsName(int pageNum, int pageSize, String goodsName) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsMapper.selectGoodsByGoodsName(goodsName));
        if(pageInfo.getTotal() != 0) {
            return  GoodsResult.pagingGoodsResult(pageNum,pageSize,pageInfo);
        }else{
            return null;
        }

    }

    @Override
    public GoodsResult selectGoodsById(int goodsId) {
        PageHelper.startPage(1, 1);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsMapper.selectGoodsById(goodsId));
        if(pageInfo.getTotal() != 0) {
            return GoodsResult.pagingGoodsResult(1,1,pageInfo);
        }else{
            return null;
        }

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
