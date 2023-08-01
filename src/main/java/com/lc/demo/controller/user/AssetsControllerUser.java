package com.lc.demo.controller.user;

import com.lc.demo.bean.Assets;
import com.lc.demo.common.Result;
import com.lc.demo.service.AssetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 资金管理
 */
@RestController
@RequestMapping("/user/userassets/assets")
@Slf4j
public class AssetsControllerUser {

    private AssetsService assetsService;
    /**
     * 查询所有assets
     * @param
     * @return
     */
    @GetMapping
    public Result<List<Assets>> list ()     {
        List<Assets> list = assetsService.selectAllAssets();
        return Result.success(list);
    }

    /**
     * 查询new_assets
     * @param
     * @return
     */
    @GetMapping("new")
    public Result<Assets>  newList ()     {
        Assets assets =assetsService.selectNewAssets();
        return Result.success(assets);
    }




}
