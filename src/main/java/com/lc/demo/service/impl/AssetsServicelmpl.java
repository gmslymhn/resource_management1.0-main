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
import java.util.List;
@Service

public class AssetsServicelmpl  implements AssetsService {
@Autowired
private AssetsMapper assetsMapper;
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
        return null;
    }

    @Override
    public float selectNewDisposableAssets() {
        float newDisposableAssets =assetsMapper.newAssets().getDisposableAssets();
        return newDisposableAssets;
    }

    @Override
    public int updateAssetsPercentage(float percentage) {
        float total =assetsMapper.newAssets().getTotalAssets();
        assetsMapper.insert(total,total*percentage, LocalDateTime.now()) ;
        return 0;
    }

    @Override
    public float selectNewTotalAssets() {
        return assetsMapper.newAssets().getTotalAssets();
    }


}
