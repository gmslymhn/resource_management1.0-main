package com.lc.demo.controller.user;

import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.User;
import com.lc.demo.service.ApplyAssetsService;
import com.lc.demo.service.UserService;
import common.ApplyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gmslymhn
 * @date 2023-08-05 15:50
 * @description:资金申请
 */
@RestController
@RequestMapping("/user/userapply")
public class UserApplyControlller {
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





}

