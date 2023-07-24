package com.lc.demo.controller;

import com.lc.demo.bean.Goods;
import com.lc.demo.service.GoodsService;
import com.lc.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



/**
 * @author 22932
 */
@RestController
@RequestMapping("/admin/admgoods")
public class AdmGoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ImageService imageService;

    /**
     * 得到一个全部物品的List
     * @return
     */
    @PostMapping("/getAllGoods")
    public List<Goods> getAllGoods(){
        return goodsService.getAllGoods();
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
     * @return
     */
    @PostMapping("/selectGoodsByGoodsName")
    public List<Goods> selectGoodsByGoodsName(String goodsName){
        return goodsService.selectGoodsByGoodsName(goodsName);
    }





}
