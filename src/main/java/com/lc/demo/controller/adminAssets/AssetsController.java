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
    public Result<String> updateTotalAssets(float totalAssets,String description){
        log.info("修改总资产:{}",totalAssets);
        assetsService.updateTotalAssets(totalAssets, description);
        return Result.success();
}


    /**
     * 修改可用资产的百分比
     * @param percentage
     * @param description
     * @return
     */
    @PutMapping("/update/percentage")
    public Result<String> updateAssetsPercentage(float percentage,String description){
        log.info("修改可用资产的百分比:{}",percentage);
        assetsService.updateAssetsPercentage(percentage, description);
        return Result.success();
    }
/**
 * 查询所有assets
 * @param pageNum
 * @param  pageSize
 * @return
 */
    @GetMapping
    public Result<AssetsPage>  list (@RequestParam int pageNum, @RequestParam int pageSize)     {
        AssetsPage list = assetsService.selectAllAssets(pageNum,pageSize);
        return Result.success(list);
}

    /**
     * 查询new_assets
     * @param
     * @return
     */
    @GetMapping("/new")
    public Result<Assets>  newList ()     {
        Assets assets =assetsService.selectNewAssets();
        return Result.success(assets);
    }


}
