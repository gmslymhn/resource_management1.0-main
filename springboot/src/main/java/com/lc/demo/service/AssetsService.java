package com.lc.demo.service;

import com.lc.demo.bean.Assets;

public interface AssetsService {

    Assets selectDisposableAssets();

    //修改验证 可以不写
    int selectDisposableAssetsHavePass();




}
