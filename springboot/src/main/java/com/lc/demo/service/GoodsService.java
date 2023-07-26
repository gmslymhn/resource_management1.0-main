package com.lc.demo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * 展示所有物品
     * @return 所有物品的集合
     */
    PageInfo<Goods> getAllGoods(int pageNum);

    /**
     * 按名字查找
     * @param goodsName 物品名称
     * @return 模糊查找出的物品集合
     */
    PageInfo<Goods> selectGoodsByGoodsName(int pageNum,String goodsName);

    /**
     * 按id查找
     * @param goodsId 物品id
     * @return id查找出的物品
     */
    Goods selectGoodsById(int goodsId);

    /**
     * 添加物品
     * @param goods 要添加物品
     * @return
     */
    int addGoods(Goods goods);

    /**
     * 更改物品
     * @param goods 更改的物品
     * @return
     */
    int updateGoods(Goods goods);

    /**
     * 删除物品
     * @param goodsId 删除物品的id
     * @return
     */
    int deleteGoods(int goodsId);

}
