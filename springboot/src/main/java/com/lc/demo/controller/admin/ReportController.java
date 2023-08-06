package com.lc.demo.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Goods;
import com.lc.demo.bean.Report;
import com.lc.demo.service.GoodsService;
import com.lc.demo.service.ReportService;
import common.GoodsResult;
import common.ReportsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 物品损坏上报
 */
@RestController
@RequestMapping("/admin/admReport")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private GoodsService goodsService;

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
        return reportService.selectByReportName(pageNum, pageSize, reportName);
    }


    /**
     * 根据处理人查询信息
     * @param pageNum
     * @param pageSize
     * @param disposeName
     * @return
     */
    @GetMapping("/selectByDisposeName")
    public ReportsResult selectByDisposeName(@RequestParam int pageNum, @RequestParam int pageSize,@RequestParam String disposeName) {
        return reportService.selectByDisposeName(pageNum, pageSize, disposeName);
    }

    /**
     * 添加上报信息
     * @param
     * @return
     */
    @GetMapping("/addReport")
    public ResponseEntity<Integer> addReport(@RequestParam int reportNameId,@RequestParam String reportName,
                                             @RequestParam int goodsId,@RequestParam String damageDescription) {
        if(goodsService.selectGoodsById(goodsId)!=null){
            Report report = new Report();
            report.setReportNameId(reportNameId);
            report.setReportName(reportName);
            report.setGoodsId(goodsId);
            report.setDamageDescription(damageDescription);
            GoodsResult good = goodsService.selectGoodsById(goodsId);
            PageInfo<Goods> goods1 = good.getData();
            Goods goods2 = goods1.getList().get(0);
            goods2.setGoodsState("已损坏");
            goodsService.updateGoods(goods2);
            reportService.addReport(report);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else {
            return new ResponseEntity<>(0, HttpStatus.OK);
        }
    }


    /**
     * 根据id删除
     * @param sequenceId
     * @return
     */
    @GetMapping("/deleteReport")
    public ResponseEntity<Integer> deleteReport(@RequestParam Integer sequenceId) {
        if( reportService.deleteReport(sequenceId) == 1){
            return ResponseEntity.ok(this.reportService.deleteReport(sequenceId));
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
