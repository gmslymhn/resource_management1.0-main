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

    @Select("select * from report")
    List<Report> selectAllReport();

    @Select("select * from report where goods_id = #{goodsId}")
    Report selectReportById(int goodsId);

    /**
     * 查询：根据上报人记录名查询记录
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


    @Insert("insert into class value(#{reportName},#{goodsId},#{goodsName},#{damageDescription},#{reportTime},#{processTime},#{goodsState},#{disposeName})")
    int insertReport(Report report);

    /**
     * todo：删除数据是否需要判断数据id是否存在
     *      情境1.用户手动输入id，需要判断，那么如何判断->查询？
     *      情况2.用户勾选数据框进行删除，确认存在无需判断
     *      假定为情况2
     * 删除：删除记录信息
     * @param goodsId
     * @return 返回整形数值为1.删除成功
     *         返回整形数值为0.删除失败
     */
    @Delete("delete from report where goods_id = #{goodsId}")
    int deleteReportById(int goodsId);


}
