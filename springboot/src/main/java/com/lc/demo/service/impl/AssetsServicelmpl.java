package com.lc.demo.service.impl;

import com.lc.demo.bean.Assets;
import com.lc.demo.service.AssetsService;
import org.springframework.stereotype.Service;

@Service
public class AssetsServicelmpl  implements AssetsService {


    @Override
    public Assets selectDisposableAssets() {
        return null;
    }

    @Override
    public int selectDisposableAssetsHavePass() {
        return 0;
    }
}