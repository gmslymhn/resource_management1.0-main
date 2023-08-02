package com.lc.demo.service;

import com.lc.demo.bean.Assets;
import com.lc.demo.common.AssetLogsPage;
import com.lc.demo.common.AssetsPage;


import java.util.List;

public interface AssetsService {


    List<Assets> selectAllAssets();

    AssetsPage selectAllAssets(int pageNum, int pageSize);

    Assets selectNewAssets();

    float   selectNewDisposableAssets();

     int   updateAssetsPercentage(float percentage);

    float   selectNewTotalAssets();








}
