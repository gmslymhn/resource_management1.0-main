package com.lc.demo.controller.admin;

import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.service.ApplyAssetsService;
import com.lc.demo.service.Assets_LogService;
import com.lc.demo.service.UserService;
import common.ApplyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gmslymhn
 * @date 2023-08-04 23:39
 * @description:资金申请
 */
@RestController
@RequestMapping("/admin/admapply")
public class AdminApplyController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApplyAssetsService applyAssetsService;

    @Autowired
    private Assets_LogService assetsLogService;


    @PostMapping("/getAllApply")
    public ApplyResult getAllApply(@RequestParam int pageNum, @RequestParam int pageSize){
        return applyAssetsService.getAllApplyAssets(pageNum,pageSize);
    }
    @PostMapping("/selectByApplyId")
    public ApplyAssets selectByApplyId(@RequestParam int applyId){
        System.out.println(applyAssetsService.selectApplyById(applyId).getDisposeTime());
        return applyAssetsService.selectApplyById(applyId);
    }
    @PostMapping("/selectByApplyName1")
    public ApplyResult selectByApplyName1(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam String applyName){
        return applyAssetsService.selectApplyByName1(pageNum,pageSize,applyName);
    }
    @PostMapping("/selectByApplyName2")
    public ApplyResult selectByApplyName2(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam String disposeName){
        return applyAssetsService.selectApplyByName2(pageNum,pageSize,disposeName);
    }
    @PostMapping("/addApply")
    public int getApplyAssetsService(@RequestBody ApplyAssets applyAssets) {
        applyAssets.setApplyState("未处理");
        return applyAssetsService.addApplyAssets(applyAssets);
    }
    @PostMapping("/updateApply")
    public  int updateApplyAssets(@RequestBody ApplyAssets applyAssets){

        if(applyAssets.getApplyId()==null){
            return 0;
        }
        ApplyAssets applyAssets1 = applyAssetsService.selectApplyById(applyAssets.getApplyId());
        if(("未处理").equals(applyAssets1.getApplyState())){
            applyAssets1.setApplyAssets(applyAssets.getApplyAssets());
            applyAssets1.setDisposeNameId(applyAssets.getDisposeNameId());
            applyAssets1.setDisposeName(applyAssets.getDisposeName());
            System.out.println(applyAssets.getApplyState());
            applyAssets1.setApplyState(applyAssets.getApplyState());
            applyAssets1.setDisposeDescription(applyAssets.getDisposeDescription());
            applyAssetsService.deleteApplyById(applyAssets.getApplyId());
            applyAssetsService.addApplyAssets(applyAssets1);
            if(applyAssets1.getApplyState().equals("已同意")){
                assetsLogService.addAssets_Log(applyAssets1.getApplyId());
            }
        }else{
            return 0;
        }
        return 1;
    }
    @PostMapping("/deleteApply")
    public int deleteApplyById (@RequestParam Integer applyId){
        return applyAssetsService.deleteApplyById(applyId);
    }

}
