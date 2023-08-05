package com.lc.demo.service.impl;

import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.Assets;
import com.lc.demo.bean.Assets_Log;
import com.lc.demo.bean.Report;
import com.lc.demo.mapper.AssetsMapper;
import com.lc.demo.mapper.Assets_LogMapper;
import com.lc.demo.service.ApplyAssetsService;
import com.lc.demo.service.Assets_LogService;
import com.lc.demo.service.ReportService;

import java.util.ArrayList;
import java.util.List;

public class Assets_LogServiceLmpl implements Assets_LogService {

    private Assets_LogMapper assetsLogMapper;
    private AssetsMapper assetsMapper;
    private ApplyAssetsService applyAssetsService;

    @Override
    public List<Assets_Log> selectAllAssets_Logs() {
        List<Assets_Log> list= assetsLogMapper.selectAllLogs();
        return list;
    }

    @Override
    public int deleteByAssets_Log(int assetsLogId) {

        assetsLogMapper.deleteByAssetsLog(assetsLogId);
        Assets_Log assetsLog =assetsLogMapper.selectByAssetsLog(assetsLogId);
        if(assetsLog ==null ){
            return 1;
        }else {
            return 0;
        }

    }

    @Override
    public void addAssets_Log(int  applyId ) {
        ApplyAssets applyAssets = applyAssetsService.selectApplyById(applyId);
        Assets_Log assetsLog =new Assets_Log();

        assetsLog.setUserName(applyAssets.getApplyName());
        assetsLog.setProcessTime(applyAssets.getDisposeTime());
        assetsLog.setChangeAssets(applyAssets.getApplyAssets());
        assetsLog.setDescription(applyAssets.getDisposeDescription());

        Assets assets=assetsMapper.newAssets();
        assetsLog.setBeforeAssets(assets.getTotalAssets());
        assetsLog.setAfterAssets(assets.getTotalAssets()-applyAssets.getApplyAssets());

        assetsLogMapper.insertAssetsLog(assetsLog);

    }

    @Override
    public int update(Assets_Log assetsLog) {
        if (assetsLog != assetsLogMapper.selectByAssetsLog(assetsLog.getAssetsLogId())) {
            assetsLogMapper.update(assetsLog);
            return 1;
        } else {
            return 0;
        }
    }
    @Override
    public Assets_Log selectById(int assetsLogId) {
        Assets_Log assetsLog=  assetsLogMapper.selectByAssetsLog(assetsLogId);
        return assetsLog;
    }

    @Override
    public List<Assets_Log> selectByName(String userName) {
        List<Assets_Log> list= (List<Assets_Log>) assetsLogMapper.selectLogByUserName(userName);
        return list;

    }
}
