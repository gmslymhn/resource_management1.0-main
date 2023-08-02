package com.lc.demo.controller.user;

import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Goods;
import com.lc.demo.service.GoodsService;
import com.lc.demo.utils.GoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getAllGoods")
    public GoodsResult getAllGoods(@RequestParam int pageNum, @RequestParam int pageSize){
        return goodsService.getAllGoods(pageNum,pageSize);

    }

    /**
     * 按id筛选物品
     * @param goodsId
     * @return
     */
    @PostMapping("/selectGoodsById")
    public Goods selectGoodsById(@RequestParam int goodsId){
        return goodsService.selectGoodsById(goodsId);
    }

    /**
     * 按物品名筛选
     * @param goodsName
     * @param pageNum 页码
     * @return
     */

}
