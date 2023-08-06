package com.lc.demo.controller.adminAssets;

import com.lc.demo.bean.Assets;
import com.lc.demo.common.AssetsPage;
import com.lc.demo.common.Result;
import com.lc.demo.service.AssetsService;

import com.lc.demo.service.impl.AssetsServicelmpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资金管理
 */
@RestController
@ResponseBody
@RequestMapping("/admin/admassets/assets")
@Slf4j
public class AssetsController {
    @Autowired

    private AssetsService assetsService;

    /**
     * 修改总资产
     * @param totalAssets
     * @param description
     * @return
     */
    @PutMapping("/update/total")
    public Result<String> updateTotalAssets(Float totalAssets,String description){
        log.info("修改总资产:{}",totalAssets);
        assetsService.updateTotalAssets(totalAssets, description);
        if (assetsService.selectNewAssets().getTotalAssets() ==totalAssets || assetsService.selectNewAssets().getDescription()==description){
            return Result.error("输入总资产或描述错误");


        }else {
        return Result.success();
}}


    /**
     * 修改总资产
     * @param description
     * @return
     */
//    @PutMapping("/update/total")
//    public Result<String> updateDescription(String description){
//        log.info("修改描述:{}",description);
//        assetsService.updateTotalAssets( description);
//        return Result.success();
//    }


    /**
     * 修改可用资产的百分比
     * @param percentage
     * @param description
     * @return
     */
    @PutMapping("/update/percentage")
    public Result<String> updateAssetsPercentage(float percentage,String description){
        if(percentage >100||percentage<0){
            return Result.error("输入百分比错误");
        }
        else {
            float percentage1 = percentage /100;
            log.info("修改可用资产的百分比:{}",percentage1);
            assetsService.updateAssetsPercentage(percentage1, description);
            return Result.success();
        }}
/**
 * 查询所有assets
 * @param pageNum
 * @param  pageSize
 * @return
 */
    @GetMapping
    public Result<AssetsPage>  list (@RequestParam int pageNum, @RequestParam int pageSize) {
        AssetsPage list = assetsService.selectAllAssets(pageNum, pageSize);
        if (list == null) {
            return Result.error("查询错误");
        } else {
            return Result.success(list);
        }
    }
    /**
     * 查询new_assets
     * @param
     * @return
     */
    @GetMapping("/new")
    public Result<Assets>  newList ()     {
        Assets assets =assetsService.selectNewAssets();
        if (assets == null) {
            return Result.error("查询错误");
        }else {
        return Result.success(assets);
    }}


}
