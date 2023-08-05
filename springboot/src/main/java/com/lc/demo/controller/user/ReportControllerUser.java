package com.lc.demo.controller.user;

import com.lc.demo.bean.Report;
import com.lc.demo.service.ReportService;
import common.ReportsResult;
import common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物品损坏上报
 */
@RestController
@RequestMapping("/user/useReport")
public class ReportControllerUser {
    @Autowired
    private ReportService reportService;

    /**
     * 查询所有上报信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getALLReport")
    public ReportsResult getALLReport(@RequestParam int pageNum, @RequestParam int pageSize) {
        return reportService.getALLReport(pageNum, pageSize);
    }

    /**
     * 根据上报人查询上报信息
     * @param pageNum
     * @param pageSize
     * @param reportName
     * @return
     */
    @GetMapping("/selectByReportName")
    public ReportsResult selectByReportName(@RequestParam int pageNum, @RequestParam int pageSize,@RequestParam String reportName) {
        return reportService.selectByReportName(pageNum, pageSize,reportName);
    }

    /**
     * 添加上报信息
     * @param report
     * @return
     */
    @PostMapping("/addReport")
    public ResponseEntity<Integer> addReport(@RequestBody Report report) {
        reportService.addReport(report);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /**
     * 根据id删除
     * @param sequenceId
     * @return
     */
    @GetMapping("/deleteReport")
    public ResponseEntity<Void> deleteReport(@RequestParam int sequenceId) {
        if( reportService.deleteReport(sequenceId) == 1){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
