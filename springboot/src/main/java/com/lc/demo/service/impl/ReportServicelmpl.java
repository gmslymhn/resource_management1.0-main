package com.lc.demo.service.impl;

import com.lc.demo.bean.Report;
import com.lc.demo.mapper.ReportMapper;
import com.lc.demo.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportServicelmpl implements ReportService {
    private ReportMapper reportMapper;

    @Override
    public List<Report> getALLReport() {
        List<Report> allReportList = reportMapper.selectAllReport();
        return allReportList;
    }

    @Override
    public Report selectById(int goodsId) {
        Report selectedReportById = reportMapper.selectReportById(goodsId);
        return selectedReportById;
    }

    //todo:service层：增添数据，未解决被增加数据 report实体对象的来源是：？   或是改变参数为具体属性
    @Override
    public int addReport(Report report) {
        int isInsertSuccess = reportMapper.insertReport(report);
        return isInsertSuccess;
    }

    @Override
    public List<Report> selectByReportName(String reportName) {

        List<Report> selectedReportsByReportName = reportMapper.selectReportByReportName(reportName);
        return selectedReportsByReportName;
    }

    @Override
    public List<Report> selectByDisposeName(String dipsoseName) {
        List<Report> selectedReportByDisposeName = reportMapper.selectReportByDisposeName(dipsoseName);
        return selectedReportByDisposeName;
    }

    @Override
    public int delecteReport(int goodsId) {
        int isDelectSuccess = reportMapper.deleteReportById(goodsId);
        return isDelectSuccess;
    }
}
