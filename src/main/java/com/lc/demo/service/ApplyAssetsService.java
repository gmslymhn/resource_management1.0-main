package com.lc.demo.service;

import com.lc.demo.bean.ApplyAssets;

import com.lc.demo.common.ApplyResult;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ApplyAssetsService {

    List<ApplyAssets> selectAllApplyAssets();

    ApplyResult getAllApplyAssets(int pageNum, int pageSize);

    //通过id查询
    ApplyAssets selectApplyById(int applyId);

    //通过上报人查询


    ApplyResult selectApplyByName1(int pageNum,int pageSize,String applyName);

    //通过处理人查询

    ApplyResult selectApplyByName2(int pageNum,int pageSize,String disposeName);

    //通过状态查询

    ApplyResult selectApplyByState(int pageNum,int pageSize,String applyState);

    //添加上报
    int addApplyAssets(ApplyAssets applyAssets);

    int deleteApplyById(int applyId);
}