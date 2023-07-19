package com.lc.demo.mapper;

import com.lc.demo.bean.Report;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReportMapper {

    @Select("select * from report")
    List<Report> selectAllReport();

    @Select("select * from report where goods_id = #{goodsId}")
    Report selectReportById(int goodsId);


    @Select("select * from report where report_name = #{reportName}")
    List<Report> selectReportByReportName(String reportName);

    @Select("select * from report where dispose_name = #{disposeName}")
    List<Report> selectReportByDisposeName(String disposeName);


    @Insert("insert into class value(#{reportName},#{goodsId},#{goodsName},#{damageDescription},#{reportTime},#{processTime},#{goodsState},#{disposeName})")
    int insertReport(Report report);

    @Delete("delect from report where goods_id = #{goodsId}")
    int deleteReportById(int goodsId);


}
