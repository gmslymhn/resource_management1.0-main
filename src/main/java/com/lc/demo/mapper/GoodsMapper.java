package com.lc.demo.mapper;

import com.lc.demo.bean.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {
    /**
     *
     * @return
     */
    @Select("select * from goods")
    List<Goods>  selectAllGoods();

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from goods where goods_id = #{GoodsId}")
    Goods  selectGoodsById(int id);

    /**
     *
     * @param goodsName
     * @return
     */
    @Select("select * from goods where goods_name like #{goodsName}")
    List<Goods>  selectGoodsByName(String goodsName);

    /**
     *
     * @param goods
     * @return
     */
    @Insert("insert into goods values(#{classId},#{goodsName},#{goodsState},#{goodsLmage}")
    int insertGoods(Goods goods);

    /**
     *
     * @param goodsId
     * @return
     */
    @Delete("delete * from class where goods_id = #{goodsId}")
    int deleteGoodsById(int goodsId);
}
