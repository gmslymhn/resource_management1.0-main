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

    @PostMapping("/getAllApply")
    public ApplyResult getAllApply(@RequestParam int pageNum, @RequestParam int pageSize){
        return applyAssetsService.getAllApplyAssets(pageNum,pageSize);
    }
    @PostMapping("/selectByApplyId")
    public ApplyAssets selectByApplyId(@RequestParam int applyId){
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
        return applyAssetsService.addApplyAssets(applyAssets);
    }
    @PostMapping("/updateApply")
    public  int updateApplyAssets(@RequestBody ApplyAssets applyAssets){
        ApplyAssets applyAssets1 = applyAssetsService.selectApplyById(applyAssets.getApplyId());
        if((applyAssets1.getApplyState())=="未处理"){
            applyAssets1.setApplyAssets(applyAssets.getApplyAssets());
            applyAssetsService.deleteApplyById(applyAssets.getApplyId());
            applyAssetsService.addApplyAssets(applyAssets1);
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
