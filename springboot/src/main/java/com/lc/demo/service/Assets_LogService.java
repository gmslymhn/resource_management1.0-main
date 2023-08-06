package com.lc.demo.service;

import com.lc.demo.bean.Assets_Log;
import common.AssetLogsPage;

import java.util.List;

public interface Assets_LogService {
    /**
     * 查询所有
     * @param
     * @return
     */
    List<Assets_Log> selectAllAssets_Logs();


    AssetLogsPage selectAllAssets_Logs(int pageNum, int pageSize);

    /**
     * 删除
     * @param   assetsLogId
     * @return
     */
    int deleteByAssets_Log(int assetsLogId);


    /**
     * 添加
     * @param  applyId
     * @return
     */
    void addAssets_Log(int  applyId ) ;

    /**
     * 修改信息
     * @param id
     * @param description
     */
    int  update(int id ,String description);


    /**
     * 根据id查询
     * @param assetsLogId
     * @return
     */
    Assets_Log selectById(int assetsLogId);
    /**
     * 根据name查询
     * @param userName
     * @return
     */
    AssetLogsPage selectByName(String userName,int pageNum, int pageSize);


}
