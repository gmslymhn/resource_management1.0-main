package com.lc.demo.controller.admin;

import com.lc.demo.bean.Report;
import com.lc.demo.service.ReportService;
import common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物品损坏上报
 */
@RestController
@RequestMapping("/admin/admReport")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 查询所有上报信息
     * @return
     */
    @GetMapping("/getALLReport")
    public Result<List<Report>> getALLReport() {
        return  Result.success(reportService.getALLReport());
    }


    /**
     * 根据id查询上报信息
     * @param goodsId
     * @return
     */
    @GetMapping("/selectById")
    public Result<Report> selectById(@RequestParam int goodsId) {
        return  Result.success(reportService.selectById(goodsId));
    }


    /**
     * 根据上报人查询上报信息
     * @param reportName
     * @return
     */
    @GetMapping("/selectByReportName")
    public Result<List<Report>> selectByReportName(@RequestParam String reportName) {
        return Result.success(reportService.selectByReportName(reportName));
    }


    /**
     * 根据处理人查询信息
     * @param disposeName
     * @return
     */
    @GetMapping("/selectByDisposeName")
    public Result<List<Report>> selectByDisposeName(@RequestParam String disposeName) {
        return Result.success(reportService.selectByDisposeName(disposeName));
    }

    /**
     * 添加上报信息
     * @param report
     * @return
     */
    @PostMapping("/addReport")
    public Result addReport(@RequestBody Report report) {
        return Result.success(reportService.addReport(report));
    }

    /**
     * 根据id删除
      * @param goodsId
     * @return
     */
    @GetMapping("/deleteReport")
    public Result deleteReport(@RequestParam int goodsId) {
        return Result.success(reportService.deleteReport(goodsId));
    }
}
