package com.lc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Goods;
import com.lc.demo.bean.Report;
import com.lc.demo.mapper.GoodsMapper;
import com.lc.demo.mapper.ReportMapper;
import com.lc.demo.service.ReportService;
import common.ReportsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public ReportsResult getALLReport(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Report> list =reportMapper.selectAllReport();
//        list.clear();
//        list.addAll(reportMapper.selectReportByState("未处理"));
//        list.addAll(reportMapper.selectReportByState("已处理"));
        PageInfo<Report> pageInfo = new PageInfo<>(list);
        if(pageInfo.getTotal() != 0) {
            return ReportsResult.pagingReportsResult(pageNum, pageInfo);
        }else{
            return null;
        }
    }

    @Override
    public int addReport(Report report) {
//        Report report1 = selectByGoodsId(report.getGoodsId());
//        if(report1 != null){
//            if(report1.getGoodsState().equals("已处理")){
//                List<Goods> goods  = goodsMapper.selectGoodsById(report.getGoodsId());
//                Goods goods1 = goods.get(0);
//                report.setGoodsName(goods1.getGoodsName());
//                report.setGoodsState("未处理");
//                report.setDisposeNameId(0);
//                report.setDisposeName("无");
//                report.setDisposeDescription("无");
//                return reportMapper.insertReport(report);
//            }
//        }else{
        System.out.println(report);
            List<Goods> goods  = goodsMapper.selectGoodsById(report.getGoodsId());
            Goods goods1 = goods.get(0);
            report.setGoodsName(goods1.getGoodsName());
            report.setGoodsState("未处理");
            report.setDisposeNameId(0);
            report.setDisposeName("无");
            report.setDisposeDescription("无");
            return reportMapper.insertReport(report);
//        }
    }

    @Override
    public ReportsResult selectByReportName(int pageNum, int pageSize, String reportName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Report> pageInfo = new PageInfo<>(reportMapper.selectReportByReportName(reportName));
        if(pageInfo.getTotal() != 0) {
            return ReportsResult.pagingReportsResult(pageNum, pageInfo);
        }else{
            return null;
        }
    }

    @Override
    public ReportsResult selectByDisposeName(int pageNum, int pageSize, String disposeName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Report> pageInfo = new PageInfo<>(reportMapper.selectReportByDisposeName(disposeName));
        if(pageInfo.getTotal() != 0) {
            return ReportsResult.pagingReportsResult(pageNum, pageInfo);
        }else{
            return null;
        }
    }
    @Override
    public int deleteReport(int sequenceId) {
        return reportMapper.deleteReportById(sequenceId);
    }
    @Override
    public Report selectById(int sequenceId) {
        return reportMapper.selectReportById(sequenceId);
    }

    @Override
    public Report selectByGoodsId(int GoodsId) {
        return reportMapper.selectReportByGoodsId(GoodsId);
    }
}
