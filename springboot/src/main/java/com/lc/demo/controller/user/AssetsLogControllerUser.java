package com.lc.demo.controller.user;

import com.lc.demo.bean.Assets_Log;
import com.lc.demo.service.Assets_LogService;
import common.AssetLogsPage;
import common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资金日志管理
 */
@RestController
@RequestMapping("/user/userassets/assetslog")
@Slf4j
public class AssetsLogControllerUser {
    @Autowired

    private Assets_LogService assetsLogService;

    /**
     * 查询所有
     *
     * @param pageNum
     * @param pageSize
     */
    @GetMapping
    public Result<AssetLogsPage> getAllAssets_Logs(@RequestParam int pageNum, @RequestParam int pageSize) {
        AssetLogsPage list = assetsLogService.selectAllAssets_Logs(pageNum, pageSize);
        return Result.success(list);
    }

    /**
     * 根据id查询
     *
     * @param assetsLogId
     * @return
     */
    @GetMapping("/{assetsLogId}")
    public Result selectById(@RequestParam int assetsLogId) {
        log.info("根据id查询:{}", assetsLogId);
        Assets_Log assetsLog = assetsLogService.selectById(assetsLogId);
        return Result.success(assetsLog);
    }

    /**
     * 根据name查询
     *
     * @param userName
     * @return
     */
    @GetMapping("/{userName}")
    public Result<AssetLogsPage> selectByName(@RequestParam String userName, @RequestParam int pageNum, @RequestParam int pageSize) {
        log.info("根据name查询:{}", userName);
        AssetLogsPage list = assetsLogService.selectByName(userName, pageNum, pageSize);
        return Result.success(list);

    }
}
