package com.lc.demo.service;

import com.lc.demo.bean.Assets_Log;

import java.util.List;

public interface Assets_LogService {
    /**
     * 查询所有
     * @param
     * @return
     */
    List<Assets_Log> selectAllAssets_Logs();
    
    /**
     * 删除
     * @param   assetsLogId
     * @return
     */
    int deleteByAssets_Log(int assetsLogId);
    
    
    /**
     * 添加
     * @param  id
     * @param change_assets
     * @param  description
     * @return
     */
     void addAssets_Log(int  id,float change_assets,String description ) ;

    /**
     * 修改信息
     * @param assetsLog
     */
    int  update(Assets_Log assetsLog);
    
    
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
    List<Assets_Log>  selectByName(String userName);


}
