package com.lc.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Goods;
import com.lc.demo.service.GoodsService;
import com.lc.demo.service.ImageService;
import com.lc.demo.service.impl.GoodsServicelmpl;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



/**
 * @author 22932
 */
@Log4j
@RestController
@RequestMapping("/admin/admgoods")
public class AdmGoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ImageService imageService;

    /**
     * 得到一个全部物品的List
     * @param pageNum 页码
     * @return 该页的List集合
     */

    @PostMapping("/getAllGoods")
    public PageInfo<Goods> getAllGoods(int pageNum){
        return goodsService.getAllGoods(pageNum);
    }

    /**
     * 添加物品
     * @param uploadImage
     * @param goods
     * @return
     */
    @PostMapping("/addGoods")
    public int addGoods(MultipartFile uploadImage,@RequestBody Goods goods){
        imageService.saveGoodsImage(uploadImage,goods);
        return goodsService.addGoods(goods);
    }

    /**
     * 更新物品
     * @param uploadImage
     * @param goods
     * @return
     */
    @PostMapping("/updateGoods")
    public int updateGoods( MultipartFile uploadImage,@RequestBody Goods goods){
        imageService.saveGoodsImage( uploadImage,goods);
        return goodsService.updateGoods(goods);
    }

    /**
     * 删除物品
     * @param goods
     * @return
     */
    @GetMapping("/deleteGoods")
    public int deleteGoods( @RequestBody Goods goods){
        return goodsService.deleteGoods(goods.getGoodsId());
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
     * @param pageNum 页码
     * @return
     */
    @PostMapping("/selectGoodsByGoodsName")
        public PageInfo<Goods> selectGoodsByGoodsName(int pageNum,String goodsName){
        return goodsService.selectGoodsByGoodsName(pageNum,goodsName);
    }





}
