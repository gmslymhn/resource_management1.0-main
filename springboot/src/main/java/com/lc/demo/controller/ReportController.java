package com.lc.demo.controller;

import com.lc.demo.bean.Goods;
import com.lc.demo.bean.Report;
import com.lc.demo.service.GoodsService;
import com.lc.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/getALLReport")
    public List<Report> getALLReport() {
        return reportService.getALLReport();
    }

    @GetMapping("/selectById")
    public Report selectById(@RequestParam int goodsId) {
        return reportService.selectById(goodsId);
    }
    @GetMapping("/addReport")
    public int addReport(@RequestParam Report report) {
        return reportService.addReport(report);
    }

    @GetMapping("/electByReportName")
    public List<Report> selectByReportName(@RequestParam String reportName) {
        return reportService.selectByReportName(reportName);
    }

    @GetMapping("/selectByDisposeName")
    public List<Report> selectByDisposeName(@RequestParam String dipsoseName) {
        return reportService.selectByDisposeName(dipsoseName);
    }
    @GetMapping("/deleteReport")

    public int deleteReport(@RequestParam int goodsId) {
        return reportService.delecteReport(goodsId);
    }
}
