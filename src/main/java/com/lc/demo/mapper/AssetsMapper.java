package com.lc.demo.mapper;

import com.lc.demo.bean.Assets;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
@Mapper
public interface AssetsMapper {
    //修改数据库

    @Update("update assets set disposeable_assets = #{disposableAssets},totalAssets = #{totalAssets} ")
    int updateeAssets(float disposableAssets,float totalAssets);

    @Update("update assets set disposeable_assets = #{disposableAssets},totalAssets = #{totalAssets} ")
    int updateDisposeableAssets(float disposableAssets);



    @Select("select * from assets")
    List<Assets> all();
    @Select("select * from assets WHERE id = (SELECT MAX(id) FROM assets)")
    Assets newAssets();

    @Insert("insert into assets (total_assets,disposable_assets,time,description,percentage)" +
            "VALUES" +
            "(#{totalAssets},#{disposableAssets},#{time},#{description},#{percentage})")
    int insert(@Param("totalAssets") float total,
               @Param("disposableAssets") float disposable,
               @Param("time") LocalDateTime now,
               @Param("description") String description,
               @Param("percentage") float percentage);;



//







}
