package com.lc.demo.service;

import com.lc.demo.bean.Report;
import common.ReportsResult;

import java.util.List;

public interface ReportService {

    /**
     * 查询：所有记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    ReportsResult getALLReport(int pageNum, int pageSize);

    /**
     * 查询：根据id查询
     * @param sequenceId
     * @return
     */
    Report selectById(int sequenceId);

    Report selectByGoodsId(int GoodsId);

    /**
     * 添加：上报信息
     * @param report
     * @return
     */

    int addReport(Report report);


    /**
     * 查询：根据上报人查询记录
     * @param pageNum
     * @param pageSize
     * @param reportName
     * @return
     */
    ReportsResult  selectByReportName(int pageNum, int pageSize,String reportName);

    /**
     * 查询：根据处理人查询记录
     * @param pageNum
     * @param pageSize
     * @param disposeName
     * @return
     */
    ReportsResult  selectByDisposeName(int pageNum, int pageSize,String disposeName);

    /**
     * 删除：删除记录信息
     * @param sequenceId
     * @return
     */
    int deleteReport(int sequenceId);


}
