package com.lc.demo.mapper;

import com.lc.demo.bean.ApplyAssets;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//`apply_id` int NOT NULL AUTO_INCREMENT COMMENT '申请id',
//        `apply_assets` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT
//        '申请资金',
//        `buy_goodsname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '购买物品名称',
//        `apply_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '申请人',
//        `dispose_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '处理人',
//        `buy_number` int NULL DEFAULT NULL COMMENT '购买数量',
//        `apply_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL COMMENT '购买描述',
//        `apply-time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
//        `dispose_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '处理时间',
//        PRIMARY KEY (`apply_id`) USING BTREE
//        ) ENGINE = InnoDB AUTO_INCREMENT = 23214 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;
@Mapper
public interface ApplyAssetsMapper {

    //查询所有申请
    @Select("select * from apply_assets")
    List<ApplyAssets> selectAllApplyAssets();

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

    @Insert("insert into apply_assets values(#{applyId},#{applyAssets},#{applyName},#{disposeName},#{applyDescription},#{applyTime},#{disposeTime},#{applyState})")
    int insertApplyAssets(ApplyAssets applyAssets);

    @Delete("delete from apply_assets where apply_id = #{applyId}")
    int deleteApplyById(int applyId);


}
