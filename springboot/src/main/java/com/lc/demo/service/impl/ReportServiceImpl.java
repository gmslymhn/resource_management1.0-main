package com.lc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Report;
import com.lc.demo.mapper.GoodsMapper;
import com.lc.demo.mapper.ReportMapper;
import com.lc.demo.service.ReportService;
import common.ReportsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public ReportsResult getALLReport(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Report> pageInfo = new PageInfo<>(reportMapper.selectAllReport());
        return ReportsResult.pagingReportsResult(pageNum, pageInfo);
    }

    @Override
    public int addReport(Report report) {
        report.setGoodsName(String.valueOf(goodsMapper.selectGoodsById(report.getGoodsId())));
        return reportMapper.insertReport(report);
    }

    @Override
    public ReportsResult selectByReportName(int pageNum, int pageSize, String reportName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Report> pageInfo = new PageInfo<>(reportMapper.selectReportByReportName(reportName));
        return ReportsResult.pagingReportsResult(pageNum, pageInfo);
    }

    @Override
    public ReportsResult selectByDisposeName(int pageNum, int pageSize, String disposeName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Report> pageInfo = new PageInfo<>(reportMapper.selectReportByDisposeName(disposeName));
        return ReportsResult.pagingReportsResult(pageNum, pageInfo);
    }

    @Override
    public int deleteReport(Integer sequenceId) {
        return reportMapper.deleteReportById(sequenceId);
    }
    @Override
    public Report selectById(int sequenceId) {
        return reportMapper.selectReportById(sequenceId);
    }
}
