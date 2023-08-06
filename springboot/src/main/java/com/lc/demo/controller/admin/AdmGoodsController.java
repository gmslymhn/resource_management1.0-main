package com.lc.demo.controller.admin;

import com.lc.demo.bean.Goods;
import com.lc.demo.service.GoodsService;
import com.lc.demo.service.ImageService;
import common.GoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



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
     * @param
     * @return 该页的List集合
     */

    @PostMapping("/getAllGoods")
    public GoodsResult getAllGoods(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        return goodsService.getAllGoods(pageNum,pageSize);
    }

    /**
     * 添加物品
     * @param
     * @param
     * @param
     * @return
     */
    @PostMapping("/addGoods")
    public ResponseEntity<Void> addGoods(@RequestParam MultipartFile uploadImage,@RequestParam String goodsName,@RequestParam String goodsState,@RequestParam Integer goodsQuantity){
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setGoodsState(goodsState);
        imageService.saveGoodsImage(uploadImage,goods);
        for(int i = 0;i < goodsQuantity;i++){
            goodsService.addGoods(goods);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新物品
     * @param uploadImage
     * @param goodsId
     * @param goodsName
     * @param goodsState
     * @return
     */
    @PostMapping("/updateGoods")
    public ResponseEntity<Void> updateGoods(@RequestParam MultipartFile uploadImage,@RequestParam int goodsId,@RequestParam String goodsName,@RequestParam String goodsState){
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setGoodsState(goodsState);
        goods.setGoodsId(goodsId);
        imageService.saveGoodsImage(uploadImage,goods);
        if(goodsService.updateGoods(goods) == 1){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * 删除物品
     * @param goodsId
     * @return
     */
    @GetMapping("/deleteGoods")
    public ResponseEntity<Void>  deleteGoods(@RequestParam Integer goodsId){

        if( goodsService.deleteGoods(goodsId) == 1){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
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
    public GoodsResult selectGoodsByGoodsName(@RequestParam int pageNum, @RequestParam  int pageSize,@RequestParam  String goodsName){
        return goodsService.selectGoodsByGoodsName(pageNum,pageSize,goodsName);
    }


}
