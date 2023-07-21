package com.lc.demo.service.impl;

import com.lc.demo.bean.Assets;
import com.lc.demo.bean.Assets_Log;
import com.lc.demo.mapper.AssetsMapper;
import com.lc.demo.mapper.Assets_LogMapper;
import com.lc.demo.service.AssetsService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class AssetsServicelmpl  implements AssetsService {

private AssetsMapper assetsMapper;
private Assets_LogMapper assetsLogMapper;
    @Override
    public List<Assets> selectAllAssets() {
        List<Assets> list=assetsMapper.all();
        return list;
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

    @Override
    public int selectDisposableAssetsHavePass() {
        if (assetsMapper.newAssets().getTotalAssets()==
                assetsLogMapper.selectNewByAssetsLog().getAfterAssets()) {
            return 1;
        }
             return 0;
    }
}
