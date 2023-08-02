package com.lc.demo.service.impl;

//<<<<<<< HEAD
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

//=======
//import com.lc.demo.bean.Goods;
//import com.lc.demo.service.GoodsService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class GoodsServicelmpl implements GoodsService {
//    @Override
//    public List<Goods> getAllGoods() {
//        return null;
//    }
//
//    @Override
//    public List<Goods> selectGoogByGoodsName(String goodsName) {
//        return null;
//    }
//
//    @Override
//    public List<Goods> selectGoodsByGoodsId(Integer goodsId) {
//        return null;
//>>>>>>> Xiaojing-Yuan

    @Override
    public Goods selectGoodsById(int goodsId) {
//<<<<<<< HEAD
        return goodsMapper.selectGoodsById(goodsId);
//=======
//        return null;
//    }
//
//    @Override
//    public Goods selectGoodsByName(String goodName) {
//        return null;
//>>>>>>> Xiaojing-Yuan
    }

    @Override
    public int addGoods(Goods goods) {
//<<<<<<< HEAD
        return goodsMapper.insertGoods(goods);
//=======
//        return 0;
//>>>>>>> Xiaojing-Yuan
    }

    @Override
    public int updateGoods(Goods goods) {
//<<<<<<< HEAD
        return goodsMapper.updateGoods(goods);
//=======
//        return 0;
//>>>>>>> Xiaojing-Yuan
    }

    @Override
    public int deleteGoods(int goodsId) {
//<<<<<<< HEAD
        return goodsMapper.deleteGoodsById(goodsId);
//=======
//        return 0;
//>>>>>>> Xiaojing-Yuan
    }
}
