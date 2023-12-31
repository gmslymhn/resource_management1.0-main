package com.lc.demo.controller.user;

import com.lc.demo.service.GoodsService;
import common.GoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping("/getAllGoods")
    public GoodsResult getAllGoods(@RequestParam int pageNum,@RequestParam int pageSize){
        return goodsService.getAllGoods(pageNum,pageSize);
    }

    /**
     * 按id筛选物品
     * @param goodsId
     * @return
     */
    @PostMapping("/selectGoodsById")
    public GoodsResult selectGoodsById(@RequestParam Integer goodsId){
        return goodsService.selectGoodsById(goodsId);
    }

    /**
     * 按物品名筛选
     * @param goodsName
     * @param pageNum 页码
     * @return
     */
    @PostMapping("/selectGoodsByGoodsName")
    public GoodsResult selectGoodsByGoodsName(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam String goodsName){
        return goodsService.selectGoodsByGoodsName(pageNum,pageSize,goodsName);
    }

}
