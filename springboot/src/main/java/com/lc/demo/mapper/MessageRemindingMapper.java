package com.lc.demo.mapper;

import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author y
 * @Date 2023/08/04 14:58
 * @Version
 */
@Mapper
public interface MessageRemindingMapper {
    /**
     * 不传入参数
     * 查询：查询未处理损坏物品信息条数
     * @return
     */
    @Select("SELECT COUNT(*) FROM report  WHERE goods_state = '未处理'")
    int selectUnprocessedReportNum();

    /**
     * 不传入参数，
     * 查询：查询未处理资金申请信息条数
     * @return
     */
    @Select("SELECT COUNT(*) FROM apply_assets  WHERE apply_state = '未处理'")
    int selectUnprocessedApplyAssetsNum();

    /**不传入参数，
     * 查询：查询未处理损坏记录信息列表
     * @return
     */
    @Select("SELECT * FROM report  WHERE goods_state = '未处理'")
    List<Report>  selectReportByGoodsState();

    /**不传入参数，
     *查询：查询未处理申请资金信息列表
     * @return
     */
    @Select("SELECT * FROM apply_assets  WHERE apply_state = '未处理'")
    List<ApplyAssets> selectApplyByApplyState();



    /**
     * 更新：根据上报id更新4个处理信息属性(上报信息状态，处理人id，处理人姓名，处理结果描述，处理时间自动更新)
     * @return
     */
    @Update("UPDATE report SET goods_state = #{goodState},dispose_name_id = #{disposeNameId},dispose_name = #{disposeName}, " +
            "dispose_description = #{disposeDescription}" +
            "WHERE sequence_id = #{sequenceId}")
    int updateReportBySequenceId(Report report);

    /**todo：Y：这里曾有个不必要的todo，现在留作快速找到Mapper页面
     * 更新：根据申请id更新4+1个处理信息属性(申请状态，处理人id，处理人姓名，处理结果描述，处理时间自动更新)
     * @return
     */
    @Update("UPDATE apply_assets set apply_state = #{applyState},dispose_name_id = #{disposeNameId}, dispose_name = #{disposeName}," +
            "apply_description = #{applyDescription} " +
            "WHERE apply_id = #{applyId}")
    int updateApplyAssetsByApplyId(ApplyAssets applyAssets);
}
