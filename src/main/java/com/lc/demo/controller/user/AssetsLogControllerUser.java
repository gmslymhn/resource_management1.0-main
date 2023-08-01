package com.lc.demo.controller.user;

import com.lc.demo.bean.Assets_Log;
import com.lc.demo.common.Result;
import com.lc.demo.service.Assets_LogService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 资金日志管理
 */
@RestController
@RequestMapping("/user/userassets/assetslog")
@Slf4j
public class AssetsLogControllerUser {
    private Assets_LogService assetsLogService;

    /**
     * 查询所有
     * @param
     * @return
     */
    @GetMapping
    public Result<List<Assets_Log>> getAllAssets_Logs(){
        List<Assets_Log> list =assetsLogService.selectAllAssets_Logs();
        return  Result.success(list);
    }

    /**
     * 根据id查询
     * @param assetsLogId
     * @return
     */
    @GetMapping("/{assetsLogId}")
    public Result selectById(@PathVariable int assetsLogId){
        log.info("根据id查询:{}",assetsLogId);
        Assets_Log assetsLog =assetsLogService.selectById(assetsLogId);
        return Result.success(assetsLog);
    }

    /**
     * 根据name查询
     * @param userName
     * @return
     */
    @GetMapping("/{userName}")
    public Result<List<Assets_Log>> selectByName(@PathVariable String userName) {
        log.info("根据name查询:{}",userName);
        List<Assets_Log> list =assetsLogService.selectByName(userName);
        return Result.success(list);

    }
}
