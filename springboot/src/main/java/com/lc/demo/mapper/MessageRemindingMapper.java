package com.lc.demo.mapper;

import com.lc.demo.bean.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author y
 * @Date 2023/08/04 14:58
 * @Version
 */
@Mapper
public interface MessageRemindingMapper {
    /**
     * 查询未处理损坏记录信息
     * @return
     */
    @Select("select * from report where good_state = 0")
    List<Report>  selectReportByGoodsState();

    /**
     *
     */
    @Update("update report set dispose_name = #{disposeName},good_state = #{goodState}, ")
    int updateReportByDisposeName();
}
