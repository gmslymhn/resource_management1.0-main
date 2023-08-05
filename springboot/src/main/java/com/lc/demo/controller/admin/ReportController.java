package com.lc.demo.controller.admin;

import com.github.pagehelper.PageHelper;
import com.lc.demo.bean.Report;
import com.lc.demo.service.ReportService;
import common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (管理员)物品损坏上报
 */
@RestController
@RequestMapping("/admin/admReport")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 查询：查询全部损坏记录信息记录
     * @return
     */
    @GetMapping("/getALLReport")
    public Result<List<Report>> getALLReport() {
        return  Result.success(reportService.getALLReport());
    }


    /**
     * 查询：根据物品id查询物品损坏信息记录
     * @param goodsId
     * @return
     */
    @GetMapping("/selectById")
    public Result<List<Report>> selectById(@RequestParam int goodsId) {
        return  Result.success(reportService.selectById(goodsId));
    }


    /**
     * 查询：根据上报人名称查询物品损坏信息记录
     * @param reportName
     * @return
     */
    @GetMapping("/selectByReportName")
    public Result<List<Report>> selectByReportName(@RequestParam String reportName) {
        return Result.success(reportService.selectByReportName(reportName));
    }


    /**
     * 查询：根据处理人名称查询物品损坏信息记录
     * @param disposeName
     * @return
     */
    @GetMapping("/selectByDisposeName")
    public Result<List<Report>> selectByDisposeName(@RequestParam String disposeName) {
        return Result.success(reportService.selectByDisposeName(disposeName));
    }

    /**
     * 增加：上报物品损坏信息
     * @param report
     * @return
     */
    @PostMapping("/addReport")
    public Result addReport(@RequestBody Report report) {
        return Result.success(reportService.addReport(report));
    }

    /**
     * 删除：根据上报id删除物品损坏信息
      * @param goodsId
     * @return
     */
    @GetMapping("/deleteReport")
    public Result deleteReport(@RequestParam int goodsId) {
        return Result.success(reportService.deleteReport(goodsId));
    }
}
