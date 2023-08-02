package com.lc.demo.controller.adminAssets;

import com.lc.demo.bean.Assets;
import com.lc.demo.common.AssetsPage;
import com.lc.demo.common.Result;
import com.lc.demo.service.AssetsService;

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
     * 修改可用资产的百分比
     * @param
     * @return
     */
    @PutMapping("/update")
    public Result<String> updateAssetsPercentage(float percentage){
        log.info("修改可用资产的百分比:{}",percentage);
        assetsService.updateAssetsPercentage(percentage);
        return Result.success();
}
/**
 * 查询所有assets
 * @param
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
