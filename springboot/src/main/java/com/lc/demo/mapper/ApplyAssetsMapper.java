package com.lc.demo.mapper;

import com.lc.demo.bean.ApplyAssets;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplyAssetsMapper {

    //查询所有申请
    @Select("select * from apply_assets")
    List<ApplyAssets> selectAllApplyAssets();
    @Results({
            @Result(property = "applyTime", column = "apply_time"),
    })

    //通过id查询
    @Select("select * from apply_assets  where apply_id = #{applyId}")
    ApplyAssets selectApplyById(int applyId);


    //通过上报人查询
    @Select("select * from apply_assets  where apply_name = #{applyName}")
    List<ApplyAssets> selectApplyByName1(String applyName);

    //通过处理人查询
    @Select("select * from apply_assets  where dispose_name = #{disposeName}")
    List<ApplyAssets> selectApplyByName2(String disposeName);

    //通过状态查询

    @Select("select * from apply_assets  where apply_state = #{applyState}")
    List<ApplyAssets> selectApplyByState(String applyState);

    //添加上报
    @Insert("insert into apply_assets(apply_id,apply_assets,apply_name_id,apply_name,dispose_name_id,dispose_name,apply_description,dispose_description,apply_state) values(#{applyId},#{applyAssets},#{applyNameId},#{applyName},#{disposeNameId},#{disposeName},#{applyDescription},#{disposeDescription},#{applyState})")
    int insertApplyAssets(ApplyAssets applyAssets);

    @Delete("delete from apply_assets where apply_id = #{applyId}")
    int deleteApplyById(int applyId);


}
