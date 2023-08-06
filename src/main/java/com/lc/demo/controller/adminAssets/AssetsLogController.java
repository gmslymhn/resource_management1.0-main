package com.lc.demo.controller.adminAssets;

import com.lc.demo.bean.Assets_Log;
import com.lc.demo.common.AssetLogsPage;
import com.lc.demo.common.Result;
import com.lc.demo.service.Assets_LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资金日志管理
 */
@RestController
@RequestMapping("/admin/admassets/assetslog")
@Slf4j
public class AssetsLogController {
    @Autowired

    private Assets_LogService  assetsLogService;

    /**
     * 查询所有
     * @param pageNum
     * @param  pageSize
     * @return
     */
    @GetMapping
    public Result<AssetLogsPage> getAllAssets_Logs(@RequestParam int pageNum, @RequestParam int pageSize){
        AssetLogsPage list =  assetsLogService.selectAllAssets_Logs(pageNum,pageSize);
        if (list == null) {
            return Result.error("查询错误");
        } else {
            return Result.success(list);
        }

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
        if (assetsLogService.selectById(assetsLogId)==null){
        return Result.success();}
        else {
            return Result.error("删除失败");
        }
    }

    /**
     * 添加
     * @param  applyId
     * @return
     */
    @PostMapping
    public Result addAssets_Log(int  applyId ) {
        log.info("新增：{}",applyId );
        assetsLogService.addAssets_Log(applyId);
        return  Result.success();
}

    /**
     * 修改信息
     * @param id
     *  @param description
     */
    @PutMapping("/update")
    public Result  update(@RequestParam  int id ,@RequestParam String description){
        log.info("修改信息:{}，{}",id,description);
        assetsLogService.update(id,description);
        if (assetsLogService.selectById(id).getDescription() ==description){
            return Result.error("修改失败");
        }else {
        return Result.success();
    }}



    /**
     * 根据id查询
     * @param assetsLogId
     * @return
     */
    @GetMapping("/{assetsLogId}")
    public Result<Assets_Log> selectById(@RequestParam int assetsLogId){
        log.info("根据日志id查询:{}",assetsLogId);
        Assets_Log assetsLog =assetsLogService.selectById(assetsLogId);
        if (assetsLog == null) {
            return Result.error("查询错误或日志id不存在");
        } else {
            return Result.success(assetsLog);
        }
    }

    /**
     * 根据name查询
     * @param userName
     * @return
     */
    @GetMapping("/{userName}")
    public Result<AssetLogsPage> selectByName(@RequestParam String userName,@RequestParam int pageNum, @RequestParam int pageSize) {
        log.info("根据name查询:{}",userName);
        AssetLogsPage list =assetsLogService.selectByName(userName,pageNum,pageSize);
        if (list == null) {
            return Result.error("查询错误或日志id不存在");
        } else {
            return Result.success(list);
        }


    }


}
