package com.lc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.lc.demo.bean.Report;
import com.lc.demo.mapper.ReportMapper;
import com.lc.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    private final Integer pageSize = 5;
    @Override
    public List<Report> getALLReport(Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<Report> allReport = reportMapper.selectAllReport();
        return allReport;
    }

    @Override
    public List<Report> selectById(Integer pageNum,int goodId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Report> selectedReportById = reportMapper.selectReportById(goodId);
        return selectedReportById;
    }


    @Override
    public List<Report> selectByReportName(Integer pageNum,String reportName) {
        PageHelper.startPage(pageNum,pageSize);
        List<Report> selectedReportByReportName = reportMapper.selectReportByReportName(reportName);
        return selectedReportByReportName;
    }

    @Override
    public List<Report> selectByDisposeName(Integer pageNum,String dipsoseName) {
        PageHelper.startPage(pageNum,pageSize);
        List<Report> selectedReportByDisposeName = reportMapper.selectReportByDisposeName(dipsoseName);
        return selectedReportByDisposeName;
    }

    @Override
    public int addReport(Report report) {
        int isAddSuccess = reportMapper.insertReport(report);
        return isAddSuccess;
    }

    @Override
    public int deleteReport(int goodsId) {
        int isDeleteSuccess = reportMapper.deleteReportById(goodsId);
        return isDeleteSuccess;
    }
}
