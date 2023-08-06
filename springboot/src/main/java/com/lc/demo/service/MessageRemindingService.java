package com.lc.demo.service;

import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.Report;
import common.MessageResultOfApply;
import common.MessageResultOfReport;

/**
 * @Author y
 * @Date 2023/08/04 14:53
 * @Version
 */

public interface MessageRemindingService {


    /**
     * 不传入参数
     * 查询：查询未处理损坏物品信息条数
     * @return 未处理上报信息条数
     */
    int selectUnprocessedReportNum();

    /**
     * 不传入参数，
     * 查询：查询未处理资金申请信息条数
     * @return 未处理申请信息条数
     */
    int selectUnprocessedApplyAssetsNum();

    /**
     * 获取各个未处理表相加后的总值
     * @return 各个未处理表信息相加后的总条数
     */
    int getMessageQuantity();

    /**传入 int 型参数页面序号pageNum，
     * 查询：查询未处理损坏记录信息列表
     * @return 未处理上报信息list包装类
     */
    MessageResultOfReport selectReportByGoodsState(int pageNum);

    /**传入 int 型参数页面序号pageNum，
     * 查询：查询未处理申请资金信息列表
     * @return 未处理申请资金list包装类
     */
    MessageResultOfApply selectApplyByApplyState(int pageNum);

    /**
     * 更新：根据上报id更新4个处理信息属性(上报信息状态，处理人id，处理人姓名，处理结果描述，处理时间自动更新)
     * @return 更新行数
     */
    int updateReportBySequenceId(Report report);

    /**
     * 更新：根据申请id更新4+1个处理信息属性(申请状态，处理人id，处理人姓名，处理结果描述，处理时间自动更新)
     * @return 更新行数
     */
    int updateApplyAssetsByApplyId(ApplyAssets applyAssets);

}
