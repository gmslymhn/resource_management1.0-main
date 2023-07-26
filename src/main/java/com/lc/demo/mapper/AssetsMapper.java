package com.lc.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface AssetsMapper {
    //修改数据库

    @Select("update assets set disposeable_assets = #{disposableAssets} where id = #{id}")
    int updateDisposeableAssets(float assetsName, int id);
}
