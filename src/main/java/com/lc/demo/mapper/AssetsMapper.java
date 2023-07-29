package com.lc.demo.mapper;

import com.lc.demo.bean.Assets;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Select("select * from assets WHERE time = (SELECT MAX(time) FROM assets)")
    Assets newAssets();

    @Insert("insert into assets (total_assets,disposable_assets,time)" +
            "VALUES" +
            "(#{totalAssets},#{disposableAssets},#{time})")
    int insert(float total, float disposable, LocalDateTime now);



//







}