package com.lc.demo.service;

import com.lc.demo.bean.Report;

import java.util.List;

public interface ReportService {

    List<Report> getALLReport();

    Report selectById(int goodsId);

    int addReport(Report report);

    //    int updateReport(Report report);
    List<Report>  selectByReportName(String reportName);

    List<Report>  selectByDisposeName(String dipsoseName);


    int delecteReport(int goodsId);


}
