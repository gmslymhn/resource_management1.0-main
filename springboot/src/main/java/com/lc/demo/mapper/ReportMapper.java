package com.lc.demo.mapper;

import com.lc.demo.bean.Report;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReportMapper {

    /**
     * 查询所有相应处理状态信息
     * @return
     */
    @Select("select * from report where goods_state = #{goodsState}")
    List<Report> selectReportByState(String goodsState);

    /**
     * 查询：根据id查询记录
     * @param sequenceId
     * @return
     */
    @Select("select * from report where sequence_id = #{sequenceId}")
    Report selectReportById(int sequenceId);

    /**
     * 查询：根据上报人名查询记录
     * @param reportName
     * @return
     */
    @Select("select * from report where report_name = #{reportName}")
    List<Report> selectReportByReportName(String reportName);

    /**
     * 查询：根据处理人查询记录
     * @param disposeName
     * @return
     */
    @Select("select * from report where dispose_name = #{disposeName}")
    List<Report> selectReportByDisposeName(String disposeName);


    /**
     * 添加上报信息
     * @param report
     * @return
     */
    @Insert("INSERT into report (report_name_id ,report_name ,goods_id,goods_name,damage_description,goods_state," +
            "dispose_name_id,dispose_name,dispose_description)" +
            "VALUES" +
            "(#{reportNameId},#{reportName},#{goodsId},#{goodsName},#{damageDescription},#{goodsState}," +
            "#{disposeNameId},#{disposeName},#{disposeDescription})")
    int insertReport(Report report);

    /**
     * 删除：删除记录信息
     * @param sequenceId
     * @return
     */
    @Delete("delete from report where sequence_id = #{sequenceId}")
    int deleteReportById(int sequenceId);


}
