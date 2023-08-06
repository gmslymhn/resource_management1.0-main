package com.lc.demo.mapper;

import com.lc.demo.bean.Assets_Log;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface Assets_LogMapper {
    /**
     * 查询所有
     * @param
     * @return
     */
    @Select("select * from assets_log")
    List<Assets_Log> selectAllLogs();



    /**
     * 根据name查询
     * @param userName
     * @return
     */
    @Select("select * from assets_log where user_name like CONCAT('%', #{userName}, '%')")
    List<Assets_Log> selectLogByUserName(String userName);



    /**
     * 根据assets_logId查询
     * @param  assetsLogId
     * @return
     */
    @Select("select * from assets_log where assets_log_id = #{assetsLogId}")
    Assets_Log selectByAssetsLog(int assetsLogId);
    /**
     * 查询new
     * @param
     * @return
     */
    @Select("select * from assets_log  WHERE time = (SELECT MAX(process_time) FROM assets_log)")
    Assets_Log selectNewByAssetsLog();


    /**
     * 添加
     * @param  log
     * @return
     */
    @Insert("insert into assets_log (user_name,description,change_assets,before_assets,afterwards_assets)" +
            "VALUES" +
            "(#{userName},#{description},#{changeAssets},#{beforeAssets},#{afterAssets})")

    @Results({
            @Result(property = "description", column = "description"),
    })

    int insertAssetsLog(Assets_Log log);



    /**
     * 删除
     * @param   assetsLogId
     * @return
     */
    @Delete("DELETE from assets_log where assets_log_id = #{assetsLogId}")
    int deleteByAssetsLog(int assetsLogId);


    /**
     * 根据主键动态修改属性
     * @param assetsLog
     */
    @Update("UPDATE assets_log SET " +
            "user_name = #{userName}," +
            " description = #{description}, " +
            "change_assets = #{changeAssets}," +
            " process_time = #{processTime}," +
            " before_assets = #{beforeAssets}, " +
            "afterwards_assets = #{afterAssets} " +
            "WHERE assets_log_id = #{assetsLogId} " )
    void update(Assets_Log assetsLog);


}
