package com.lc.demo.mapper;

import com.lc.demo.bean.Assets_Log;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Assets_LogMapper {
    @Select("select * from assets_log")
    List<Assets_Log> selectAllLogs();

    @Select("select * from assets_log where user_name = #{userName}")
    Assets_Log selectLogByUserName(String userName);
    @Select("select * from assets_log where assets_log_id = #{assetsLogId}")
    Assets_Log selectLogById(int assetsLogId);

    @Insert("insert into assets_log values(#{assetsLogId},#{userName},#{dascription},#{changeAssets},#{processTime},#{beforeAssets},#{afterAssets}")
    int insertAssetsLog(Assets_Log log);

    @Delete("DELETEE from assets_log where assets_log_id = #{assetsLogId}")
    int deleteLogById(int assetsLogId);





}
