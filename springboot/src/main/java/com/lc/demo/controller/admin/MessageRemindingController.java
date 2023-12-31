package com.lc.demo.controller.admin;

import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.Report;
import com.lc.demo.service.ApplyAssetsService;
import com.lc.demo.service.AssetsService;
import com.lc.demo.service.Assets_LogService;
import com.lc.demo.service.MessageRemindingService;
import common.MessageResultOfApply;
import common.MessageResultOfReport;
import common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 消息提醒
 */
@RestController
@RequestMapping("/admin/messageReminding")
public class MessageRemindingController {
    @Autowired
    private MessageRemindingService messageRemindingService;
    @Autowired
    private AssetsService assetsService;
    @Autowired
    private ApplyAssetsService applyAssetsService;
    @Autowired
    private Assets_LogService assetsLogService;

    /**
     * 不传入参数，
     * 查询：查询未损坏物品上报信息条数
     * @return 未处理上报信息条数
     */
    @GetMapping("/getUnprocessedReportNum")
     public Result<Integer> selectUnprocessedReportNum(){
        int unprocessedReportNum = messageRemindingService.selectUnprocessedReportNum();

        return Result.success(unprocessedReportNum);
    }

    /**
     * 不传入参数，
     * 查询：查询未处理资金申请信息条数
     * @return 未处理申请信息条数
     */
    @GetMapping("/getUnprocessedApplyAssetsNum")
    public Result<Integer> selectUnprocessedApplyAssetsNum(){
        int unprocessedApplyAssetsNum = messageRemindingService.selectUnprocessedApplyAssetsNum();
        return Result.success(unprocessedApplyAssetsNum);

    }

    /**
     * 获取各个未处理表相加后的总值
     * @return 各个未处理表信息相加后的总条数
     */
    @GetMapping("/getMessageQuantity")
    public Result<Integer> getMessageQuantity() {
        int messageQuantity = messageRemindingService.getMessageQuantity();
        return Result.success(messageQuantity);
    }

    /**传入 int 型参数页面序号pageNum，
     * 查询：查询未处理损坏记录信息列表
     * @return 未处理上报信息list包装类
     */
    @GetMapping("/getUnprocessedReport")
    public MessageResultOfReport selectReportByGoodsState(@RequestParam int pageNum){
        return messageRemindingService.selectReportByGoodsState(pageNum);
    }

    /**传入 int 型参数页面序号pageNum，
     * 查询：查询未处理申请资金信息列表
     * @return 未处理申请资金list包装类
     */
    @GetMapping("/getUnprocessedApply")
    public MessageResultOfApply selectApplyByApplyState(@RequestParam int pageNum){
        return messageRemindingService.selectApplyByApplyState(pageNum);
    }


    /**
     *
     * 更新：根据上报id更新4个处理信息属性(上报信息状态，处理人id，处理人姓名，处理结果描述，处理时间自动更新)
     * @return 更行行数
     */
    @PostMapping("/UpdateProcessedReport")
    public ResponseEntity<Void> updateReportBySequenceId(@RequestParam int sequenceId, @RequestParam String goodsState, @RequestParam int disposeNameId, @RequestParam String disposeName, @RequestParam String disposeDescription){
        Report report = new Report();
        report.setSequenceId(sequenceId);
        report.setGoodsState(goodsState);
        report.setDisposeNameId(disposeNameId);
        report.setDisposeName(disposeName);
        report.setDisposeDescription(disposeDescription);
        if(messageRemindingService.updateReportBySequenceId(report)==1){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * 更新：根据申请id更新4+1个处理信息属性(申请状态，处理人id，处理人姓名，处理结果描述，处理时间自动更新)
     * @return 更行行数
     */
    @PostMapping("/UpdateProcessedApply")
    public int updateApplyAssetsByApplyId(@RequestParam int applyId, @RequestParam String applyState, @RequestParam int disposeNameId, @RequestParam String disposeName, @RequestParam String disposeDescription){
       ApplyAssets applyAssets1  =applyAssetsService.selectApplyById(applyId);
        ApplyAssets applyAssets = new ApplyAssets();
        applyAssets.setApplyId(applyId);
        applyAssets.setApplyState(applyState);
        applyAssets.setDisposeNameId(disposeNameId);
        applyAssets.setDisposeName(disposeName);
        applyAssets.setDisposeDescription(disposeDescription);
        System.out.println(applyState);
        System.out.println(applyAssets1.getApplyAssets());
        if(messageRemindingService.updateApplyAssetsByApplyId(applyAssets)==1){
            if(("同意").equals(applyState)&&assetsService.selectNewDisposableAssets()>=applyAssets1.getApplyAssets()){
                assetsLogService.addAssets_Log(applyAssets1.getApplyId());
            }else {
                applyAssets.setApplyState("未处理");
                messageRemindingService.updateApplyAssetsByApplyId(applyAssets);
                return 0;
            }
            return 1;
        }else {
            return 0;
        }
    }
}
