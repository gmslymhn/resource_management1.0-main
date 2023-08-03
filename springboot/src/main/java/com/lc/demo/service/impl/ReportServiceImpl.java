package com.lc.demo.service.impl;

import com.lc.demo.bean.Report;
import com.lc.demo.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportServiceImpl implements ReportService {
    private ReportMapper reportMapper;

    @Override
    public List<Report> getALLReport() {
        return null;
    }

    @Override
    public Report selectById(int goodsId) {
        return null;
    }

    @Override
    public int addReport(Report report) {
        return 0;
    }

    @Override
    public List<Report> selectByReportName(String reportName) {
        return null;
    }

    @Override
    public List<Report> selectByDisposeName(String dipsoseName) {
        return null;
    }

    @Override
    public int deleteReport(int goodsId) {
        int isDeleteSuccess = reportMapper.deleteReportById(goodsId);
        return isDeleteSuccess;
    }
}
