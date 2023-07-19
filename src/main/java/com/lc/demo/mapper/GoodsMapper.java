package com.lc.demo.mapper;

import com.lc.demo.bean.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {

    @Select("select * from goods")
    List<Goods>  selectAllGoods();

    @Select("select * from goods where goods_id = #{GoodsId}")
    Goods  selectGoodsById(int id);


    @Select("select * from goods where goods_name like #{goodsName}")
    List<Goods>  selectGoodsByName(String goodsName);

    @Insert("insert into goods values(#{classId},#{goodsName},#{goodsState},#{goodsLmage}")
    int insertGoods(Goods goods);

    @Delete("delete * from class where goods_id = #{goodsId}")
    int deleteGoodsById(int goodsId);
}
