package com.lc.demo.service;

import com.lc.demo.bean.Report;

import java.util.List;

public interface ReportService {
    /**
     * 查询：查询全部损坏记录信息记录
     * @return
     */
    List<Report> getALLReport(Integer pageNum);

    /**
     * 查询：根据物品id查询物品损坏信息记录
     * @param goodsId
     * @return
     */
    List<Report> selectById(Integer pageNum,int goodsId);


    /**
     * 查询：根据上报人名称查询物品损坏信息记录
     * @param reportName
     * @return
     */
    List<Report>  selectByReportName(Integer pageNum,String reportName);

    /**
     * 查询：根据处理人名称查询物品损坏信息记录
     * @param disposeName
     */
    List<Report>  selectByDisposeName(Integer pageNum,String disposeName);

    /**
     * 增加：上报物品损坏信息
     * @param report
     * @return  返回整形数值为1.上报成功
     *          返回整形数值为0.上报失败
     */
    int addReport(Report report);
    /**
     * 删除：根据上报id删除物品损坏信息
     * @param sequenceId
     * @return  返回整形数值为1.删除成功
     *          返回整形数值为0.删除失败
     */
    int deleteReport(int sequenceId);



}
