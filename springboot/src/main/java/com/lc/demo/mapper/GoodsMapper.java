package com.lc.demo.mapper;

import com.lc.demo.bean.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author wzy
 */

@Mapper
@Repository
public interface GoodsMapper {

    /**
     * 数据库查询所有操作
     * @return Goods集合
     */
    @Select("select * from goods")
    List<Goods>  selectAllGoods();

    /**
     * 通过id查找物品
     * @param id
     * @return 一个Goods
     */
    @Select("select * from goods where goods_id = #{goodsId} ")
        Goods  selectGoodsById(int id);

    /**
     * 通过name模糊查找
     * @param goodsName
     * @return Goods集合
     */
    @Select("select * from goods where goods_name like '%${goodsName}%' ")
    List<Goods>  selectGoodsByGoodsName(@Param("goodsName") String goodsName);

    /**
     * 添加物品
     * @param goods
     * @return
     */
    @Insert("insert into goods values(#{goodsId},#{goodsName},#{goodsState},#{goodsImage})")
    int insertGoods(Goods goods);

    /**
     * 修改物品
     * @param goods
     * @return
     */
    @Update("update goods set goods_Name = #{goodsName},goods_State = #{goodsState},goods_Image = #{goodsImage} where goods_Id = #{goodsId} ")
    int updateGoods(Goods goods);

    /**
     * 删除物品
     * @param goodsId
     * @return
     */
    @Delete("delete from goods where goods_id = #{goodsId}")
    int deleteGoodsById(int goodsId);
}
