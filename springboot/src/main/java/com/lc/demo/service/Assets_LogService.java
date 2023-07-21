package com.lc.demo.service;

import com.lc.demo.bean.Assets_Log;

import java.util.List;

public interface Assets_LogService {

    List<Assets_Log> getAllAssets_Logs();

    //日志不可修改
//    Assets_Log selectById(int assetsLogId);
//
//    Assets_Log  selectByName(String userName);

    int deleteById(int assetsLogId);

    int addAssets_Log(Assets_Log assets_Log);

    List<Assets_Log> selectLogByAssetsId(int assetsId);

}
