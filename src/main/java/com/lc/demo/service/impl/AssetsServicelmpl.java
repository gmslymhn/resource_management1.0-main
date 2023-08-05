package com.lc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Assets;
import com.lc.demo.bean.Assets_Log;
import com.lc.demo.common.AssetLogsPage;
import com.lc.demo.common.AssetsPage;
import com.lc.demo.mapper.AssetsMapper;
import com.lc.demo.mapper.Assets_LogMapper;
import com.lc.demo.service.AssetsService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
@Service

public class AssetsServicelmpl  implements AssetsService {

    @Autowired
    private AssetsMapper assetsMapper;
    @Autowired
    private Assets_LogMapper assetsLogMapper;

    @Override

    public List<Assets> selectAllAssets() {
        List<Assets> list=assetsMapper.all();
        return list;
    }

    @Override

    public AssetsPage selectAllAssets(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Assets> list=assetsMapper.all();
        PageInfo<Assets> pageInfo = new PageInfo<>(list);
        return AssetsPage.pagingAssetsResult(pageSize,pageInfo);
    }
    @Override
    public Assets selectNewAssets() {
        Assets assets = assetsMapper.newAssets();
        return assets;
    }

    @Override
    public float selectNewDisposableAssets() {
        float newDisposableAssets =assetsMapper.newAssets().getDisposableAssets();
        return newDisposableAssets;
    }

//    @Override
//    public void updateAssetsPercentage(float percentage,String description) {
//        float total =assetsMapper.newAssets().getTotalAssets();
//        assetsMapper.insert(total,total*percentage, LocalDateTime.now(),description,percentage) ;
//
//    }

    public void updateAssetsPercentage(float percentage,String description) {
        float total =assetsMapper.newAssets().getTotalAssets();
        assetsMapper.insert(total,total*percentage, LocalDateTime.now(),description,percentage) ;

    }

    public void updateTotalAssets(Float totalAssets,String description) {

        if (totalAssets == null) {
            // 处理totalAssets为空的情况
            throw new IllegalArgumentException("总资产不能为空。");
        }

        float percentage = assetsMapper.newAssets().getPercentage();
        assetsMapper.insert(totalAssets, totalAssets * percentage, LocalDateTime.now(), description, percentage);
    }

    @Override
    public void insertAssets( float totalAssets, float disposableAssets, float percentage, String description) {
        assetsMapper.insert(totalAssets,disposableAssets,LocalDateTime.now(),description,percentage);
    }


    @Override
    public float selectNewTotalAssets() {
        return assetsMapper.newAssets().getTotalAssets();
    }


}
