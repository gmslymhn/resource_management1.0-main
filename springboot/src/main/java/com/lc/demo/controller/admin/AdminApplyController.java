package com.lc.demo.controller.admin;

import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.Report;
import com.lc.demo.service.ApplyAssetsService;
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
    private ApplyAssetsService applyAssetsService;

    @GetMapping("/getAllApply")
    public ApplyResult getAllApply(@RequestParam int pageNum, @RequestParam int pageSize){
        return applyAssetsService.getAllApplyAssets(pageNum,pageSize);
    }
    @GetMapping("/selectByApplyId")
    public ApplyAssets selectByApplyId(@RequestParam int applyId){
        return applyAssetsService.selectApplyById(applyId);
    }
    @GetMapping("/selectByApplyName1")
    public ApplyResult selectByApplyName1(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam String applyName){
        return applyAssetsService.selectApplyByName1(pageNum,pageSize,applyName);
    }
    @GetMapping("/selectByApplyName2")
    public ApplyResult selectByApplyName2(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam String disposeName){
        return applyAssetsService.selectApplyByName2(pageNum,pageSize,disposeName);
    }
    @PostMapping("/addApply")
    public ApplyAssetsService getApplyAssetsService() {
        return applyAssetsService;
    }


    @GetMapping("/deleteApply")
    public int deleteApplyById (@RequestParam int applyId){
        return applyAssetsService.deleteApplyById(applyId);
    }



}
