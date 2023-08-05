package com.lc.demo.service.impl;

import com.lc.demo.bean.Report;
import com.lc.demo.mapper.ReportMapper;
import com.lc.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportServicelmpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<Report> getALLReport() {
        return reportMapper.selectAllReport();
    }

    @Override
    public Report selectById(int goodsId) {
        return reportMapper.selectReportById(goodsId);
    }

    @Override
    public int addReport(Report report) {
        return reportMapper.insertReport(report);
    }

    @Override
    public List<Report> selectByReportName(String reportName) {
        return reportMapper.selectReportByReportName(reportName);
    }

    @Override
    public List<Report> selectByDisposeName(String dipsoseName) {
        return reportMapper.selectReportByDisposeName(dipsoseName);
    }

    @Override
    public int delecteReport(int goodsId) {
        return reportMapper.deleteReportById(goodsId);
    }
}
