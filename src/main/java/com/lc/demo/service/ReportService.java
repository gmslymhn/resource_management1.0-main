package com.lc.demo.service;

import com.lc.demo.bean.Report;

import java.util.List;

public interface ReportService {

    /**
     * 查询：查询所有物品损坏记录
     * @return
     */
    List<Report> getALLReport();

    /**
     * 查询：根据物品id查询记录
     * @param goodsId
     * @return
     */
    Report selectById(int goodsId);

    /**
     * 添加：增加记录信息
     * @param report
     * @return
     */
    int addReport(Report report);

    //    int updateReport(Report report);

    /**
     * 查询：根据上报信息记录名查询记录
     * @param reportName
     * @return
     */
    List<Report>  selectByReportName(String reportName);

    /**
     * 查询：根据处理结果查询记录
     * @param dipsoseName
     */
    List<Report>  selectByDisposeName(String dipsoseName);

    /**
     * 删除：删除记录信息
     * @param goodsId
     * @return
     */
    int delecteReport(int goodsId);


}