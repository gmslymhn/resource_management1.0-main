package com.lc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.Assets;
import com.lc.demo.bean.Assets_Log;
import com.lc.demo.mapper.AssetsMapper;
import com.lc.demo.mapper.Assets_LogMapper;
import com.lc.demo.service.ApplyAssetsService;
import com.lc.demo.service.AssetsService;
import com.lc.demo.service.Assets_LogService;
import com.lc.demo.service.ReportService;
import common.AssetLogsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Assets_LogServiceLmpl implements Assets_LogService {

    @Autowired
    private Assets_LogMapper assetsLogMapper;
    @Autowired
    private AssetsMapper assetsMapper;
    @Autowired
    private ReportService  reportService;
    @Autowired
    private ApplyAssetsService applyAssetsService;

    @Autowired
    private AssetsService assetsService;

    @Override
    public List<Assets_Log> selectAllAssets_Logs() {
        List<Assets_Log> list= assetsLogMapper.selectAllLogs();
        return list;
    }

    @Override
    public AssetLogsPage selectAllAssets_Logs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Assets_Log> pageInfo = new PageInfo<>(assetsLogMapper.selectAllLogs());
        if(pageInfo.getTotal() != 0) {
            return AssetLogsPage.pagingAssetsLogResult(pageSize,pageInfo);
        }else{
            return null;
        }
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

        assetsLog.setUserName(applyAssets.getDisposeName());//处理人
        assetsLog.setProcessTime(applyAssets.getDisposeTime());
        assetsLog.setChangeAssets(applyAssets.getApplyAssets());
        assetsLog.setDescription(applyAssets.getDisposeDescription());//要改

        Assets assets=assetsMapper.newAssets();
        assetsLog.setBeforeAssets(assets.getTotalAssets());
        assetsLog.setAfterAssets(assets.getTotalAssets()-applyAssets.getApplyAssets());
        System.out.println(assetsLog);
        assetsLogMapper.insertAssetsLog(assetsLog);
        float disposableAssets = assets.getDisposableAssets() - applyAssets.getApplyAssets();
        if (disposableAssets < 0) {
            System.out.println("可用资金不足");
        } else {
            assetsService.insertAssets(assets.getTotalAssets() - applyAssets.getApplyAssets(), disposableAssets, assets.getPercentage(), applyAssets.getDisposeDescription());
        }
    }

    @Override
    public int update(int id ,String description) {
        Assets_Log  assetsLog=assetsLogMapper.selectByAssetsLog(id);
        assetsLog.setDescription(description);
        if (assetsLog != assetsLogMapper.selectByAssetsLog(id)) {
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
    public AssetLogsPage selectByName(String userName, int pageNum, int pageSize) {
        List<Assets_Log> list=  assetsLogMapper.selectLogByUserName(userName);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Assets_Log> pageInfo = new PageInfo<>(list);
        if(pageInfo.getTotal() != 0) {
            return AssetLogsPage.pagingAssetsLogResult(pageSize,pageInfo);
        }else{
            return null;
        }
    }
}
