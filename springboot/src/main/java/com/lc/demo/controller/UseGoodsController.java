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

    @PostMapping("/selectGoodsById")
    public Goods selectGoodsById(int goodsId){
        System.out.println(goodsService.selectGoodsById(goodsId));
        return goodsService.selectGoodsById(goodsId);
    }

    @PostMapping("/selectGoodsByGoodsName")
    public List<Goods> selectGoodsByGoodsName(String goodsName){
        System.out.println(goodsName);
        return goodsService.selectGoodsByGoodsName(goodsName);
    }

}
