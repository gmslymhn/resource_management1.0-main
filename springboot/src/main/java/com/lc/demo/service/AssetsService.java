package com.lc.demo.service;

import com.lc.demo.bean.Assets;
import common.AssetsPage;


import java.util.List;

public interface AssetsService {


    List<Assets> selectAllAssets();

    AssetsPage selectAllAssets(int pageNum, int pageSize);

    Assets selectNewAssets();

    float   selectNewDisposableAssets();

    void    updateAssetsPercentage(float percentage,String description);

    void updateTotalAssets(Float totalAssets,String description) ;

    void insertAssets(  float totalAssets, float disposableAssets, float percentage, String description);

    float   selectNewTotalAssets() ;

}
