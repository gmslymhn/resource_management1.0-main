package com.lc.demo.mapper;

import com.lc.demo.bean.Report;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReportMapper {

    /**
     * 查询所有上报信息
     * @return Report集合
     */
    @Select("select * from report")
    List<Report> selectAllReport();

    /**
     * 通过id查找上报信息
     * @param goodsId
     * @return Report集合
     */
    @Select("select * from report where goods_id = #{goodsId}")
    Report selectReportById(int goodsId);

    /**
     * 通过上报名称查找上报信息
     * @param reportName
     * @return Report集合
     */
    @Select("select * from report where report_name = #{reportName}")
    List<Report> selectReportByReportName(String reportName);

    /**
     * 根据处理人查询上报信息
     * @param disposeName
     * @return Report集合
     */
    @Select("select * from report where dispose_name = #{disposeName}")
    List<Report> selectReportByDisposeName(String disposeName);

    /**
     * 添加上报信息
     * @param report
     * @return
     */
    @Insert("insert into class value(#{reportName},#{goodsId},#{goodsName},#{damageDescription},#{reportTime},#{processTime},#{goodsState},#{disposeName})")
    int insertReport(Report report);

    /**
     * 删除上报信息
     * @param goodsId
     * @return
     */
    @Delete("delect from report where goods_id = #{goodsId}")
    int deleteReportById(int goodsId);


}
