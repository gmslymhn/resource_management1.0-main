package com.lc.demo.controller;

import com.lc.demo.bean.Goods;
import com.lc.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 22932
 */
@RestController
@RequestMapping("/user/usegoods")
public class UseGoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 得到一个全部物品的List
     * @return
     */
    @PostMapping("/getAllGoods")
    public List<Goods> getAllGoods(){
        return goodsService.getAllGoods();
    }

    /**
     * 按id筛选物品
     * @param goodsId
     * @return
     */
    @PostMapping("/selectGoodsById")
    public Goods selectGoodsById(int goodsId){
        return goodsService.selectGoodsById(goodsId);
    }

    /**
     * 按物品名筛选
     * @param goodsName
     * @return
     */
    @PostMapping("/selectGoodsByGoodsName")
    public List<Goods> selectGoodsByGoodsName(String goodsName){
        return goodsService.selectGoodsByGoodsName(goodsName);
    }

}
