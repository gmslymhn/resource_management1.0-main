package com.lc.demo.service;

import com.lc.demo.bean.Report;

import java.util.List;

public interface ReportService {

    List<Report> getALLReport();

    Report selectById(int goodsId);

    int addReport(Report report);

    //    int updateReport(Report report);

    /**
     * 查询：根据上报人查询记录
     * @param reportName
     * @return
     */
    List<Report>  selectByReportName(String reportName);

    /**
     * 查询：根据处理人查询记录
     * @param disposeName
     */
    List<Report>  selectByDisposeName(String disposeName);

    /**
     * 删除：删除记录信息
     * @param goodsId
     * @return
     */
    int deleteReport(int goodsId);


}
