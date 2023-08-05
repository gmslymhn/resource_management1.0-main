package com.lc.demo.controller.admin;

import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.Report;
import com.lc.demo.bean.User;
import com.lc.demo.service.ApplyAssetsService;
import com.lc.demo.service.UserService;
import common.ApplyResult;
import common.GoodsResult;
import common.ReportsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    @Autowired
//    private

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
        User user = userService.selectByAccount(applyAssets.getApplyName());
        applyAssets.setApplyNameId(user.getUserId());
        applyAssets.setApplyName(user.getUserName());
        applyAssets.setApplyState("未处理");
        return applyAssetsService.addApplyAssets(applyAssets);
    }
    @PostMapping("/updateApply")
    public  int updateApplyAssets(@RequestBody ApplyAssets applyAssets){
        System.out.println(applyAssets);
        ApplyAssets applyAssets1 = applyAssetsService.selectApplyById(applyAssets.getApplyId());
        if((applyAssets1.getApplyState()).equals("未处理")){
            applyAssets1.setApplyAssets(applyAssets.getApplyAssets());
            applyAssets1.setDisposeNameId(applyAssets.getDisposeNameId());
            applyAssets1.setDisposeName(applyAssets.getDisposeName());
            System.out.println(applyAssets.getApplyState());
            applyAssets1.setApplyState(applyAssets.getApplyState());
            applyAssetsService.deleteApplyById(applyAssets.getApplyId());
            applyAssetsService.addApplyAssets(applyAssets1);
            if(applyAssets1.getApplyState().equals("已同意")){

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
