package com.lc.demo.controller;

import com.lc.demo.bean.Goods;
import com.lc.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



/**
 * @author 22932
 */
@RestController
@RequestMapping("/admin/admgoods")
public class AdmGoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/getAllGoods")
    public List<Goods> getAllGoods(){
        return goodsService.getAllGoods();
    }

    @PostMapping("/addGoods")
    public int addGoods(@RequestBody Goods goods){
        System.out.println();
        return goodsService.addGoods(goods);
    }

    @PostMapping("/updateGoods")
    public int updateGoods(@RequestBody Goods goods){
        return goodsService.updateGoods(goods);
    }

    @GetMapping("/deleteGoods")
    public int deleteGoods( @RequestBody Goods goods){

        return goodsService.deleteGoods(goods.getGoodsId());
    }

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
