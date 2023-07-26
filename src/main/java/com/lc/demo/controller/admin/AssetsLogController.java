package com.lc.demo.controller.admin;

import com.lc.demo.bean.Assets_Log;
import com.lc.demo.service.Assets_LogService;
import com.mysql.cj.log.Log;
import common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * 资金日志管理
 */
@RestController
@RequestMapping("/admin/admassets/assetslog")
@Slf4j
public class AssetsLogController {
    private Assets_LogService  assetsLogService;

    /**
     * 查询所有
     * @param
     * @return
     */
    @GetMapping
    public  Result<List<Assets_Log>> getAllAssets_Logs(){
        List<Assets_Log> list =assetsLogService.selectAllAssets_Logs();
        return  Result.success(list);
    }

    /**
     * 删除
     * @param   assetsLogId
     * @return
     */
    @DeleteMapping("/{assetsLogId}")
     public Result deleteByAssets_Log(int assetsLogId){
        log.info("删除：{}", assetsLogId);
        assetsLogService.deleteByAssets_Log(assetsLogId);
        return Result.success();
    }

    /**
     * 添加
     * @param  id
     * @param change_assets
     * @param  description
     * @return
     */
    @PostMapping
    public Result addAssets_Log(int  id,float change_assets,String description ) {
        log.info("新增：{},{},{}",id,change_assets,description );
        assetsLogService.addAssets_Log(id,change_assets,description);
        return  Result.success();
}

    /**
     * 修改信息
     * @param assetsLog
     */
    @PutMapping
    public Result  update(@RequestBody Assets_Log assetsLog){
        log.info("修改信息:{}",assetsLog);
        assetsLogService.update(assetsLog);
        return Result.success();
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
