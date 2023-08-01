package com.lc.demo.service;

import com.lc.demo.bean.Assets;


import java.util.List;

public interface AssetsService {


    List<Assets> selectAllAssets();


    Assets selectNewAssets();

    float   selectNewDisposableAssets();

     int   updateAssetsPercentage(float percentage);

    float   selectNewTotalAssets();








}
