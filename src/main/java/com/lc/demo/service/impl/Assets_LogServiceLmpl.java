package com.lc.demo.service.impl;

import com.lc.demo.bean.Assets_Log;
import com.lc.demo.mapper.Assets_LogMapper;
import com.lc.demo.service.Assets_LogService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Assets_LogServiceLmpl implements Assets_LogService {


    @Override
    public List<Assets_Log> getAllAssets_Logs() {
        return null;
    }

    @Override
    public int deleteById(int assetsLogId) {
        return 0;
    }

    @Override
    public int addAssets_Log(Assets_Log assets_Log) {
        return 0;
    }

    @Override
    public List<Assets_Log> selectLogByAssetsId(int assetsId) {
        return null;
    }
}
