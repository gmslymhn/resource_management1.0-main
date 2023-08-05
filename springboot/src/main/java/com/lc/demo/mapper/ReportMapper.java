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
     * 查询：查询全部损坏记录信息记录
     * @return
     */
    @Select("select * from report")
    List<Report> selectAllReport();

    /**
     * 查询：根据物品id查询物品损坏信息记录
     * @param goodsId
     * @return
     */
    @Select("select * from report where goods_id = #{goodsId}")
    List<Report> selectReportById(int goodsId);

    /**
     * 查询：根据上报人名称查询物品损坏信息记录
     * @param reportName
     * @return
     */
    @Select("select * from report where report_name = #{reportName}")
    List<Report> selectReportByReportName(String reportName);

    /**
     * 查询：根据处理人名称查询物品损坏信息记录
     * @param disposeName
     * @return
     */
    @Select("select * from report where dispose_name = #{disposeName}")
    List<Report> selectReportByDisposeName(String disposeName);

    /**
     * 增加：上报物品损坏信息
     * @param report
     * @return  返回整形数值为1.上报成功
     *          返回整形数值为0.上报失败
     */
    @Insert("insert into class value(#{reportName},#{goodsId},#{goodsName},#{damageDescription},#{reportTime},#{processTime},#{goodsState},#{disposeName})")
    int insertReport(Report report);

    /**
     * 删除：根据上报id删除物品损坏信息
     * @param sequenceId
     * @return 返回整形数值为1.删除成功
     *         返回整形数值为0.删除失败
     */
    @Delete("delect from report where sequence_id = #{sequenceId}")
    int deleteReportById(int sequenceId);

}
