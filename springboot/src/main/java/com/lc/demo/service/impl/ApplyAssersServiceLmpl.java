package com.lc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.Goods;
import com.lc.demo.mapper.ApplyAssetsMapper;
import com.lc.demo.service.ApplyAssetsService;
import com.lc.demo.service.Assets_LogService;
import common.ApplyResult;
import common.GoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gmslymhn
 * @date 2023-08-04 22:49
 * @description:资金申请
 */
@Service
public class ApplyAssersServiceLmpl implements ApplyAssetsService {

    @Autowired
    private ApplyAssetsMapper applyAssetsMapper;


    @Override
    public List<ApplyAssets> selectAllApplyAssets() {
        List<ApplyAssets> list1 = applyAssetsMapper.selectApplyByState("未处理");
        List<ApplyAssets> list2 = applyAssetsMapper.selectApplyByState("未同意");
        List<ApplyAssets> list3 = applyAssetsMapper.selectApplyByState("已同意");
        List<ApplyAssets> list = list1;
        list.addAll(list2);
        list.addAll(list3);
        return list;
    }

    @Override
    public ApplyResult getAllApplyAssets(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<ApplyAssets> pageInfo = new PageInfo<>(selectAllApplyAssets());
        if(pageInfo.getTotal() != 0) {
            return ApplyResult.pagingApplyResult(pageSize,pageInfo);
        }else{
            return null;
        }
    }

    @Override
    public ApplyAssets selectApplyById(int applyId) {
        return applyAssetsMapper.selectApplyById(applyId);
    }

    @Override
    public ApplyResult selectApplyByName1(int pageNum, int pageSize, String applyName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<ApplyAssets> pageInfo = new PageInfo<>(applyAssetsMapper.selectApplyByName1(applyName));
        if(pageInfo.getTotal() != 0) {
            return ApplyResult.pagingApplyResult(pageSize,pageInfo);
        }else{
            return null;
        }
    }

    @Override
    public ApplyResult selectApplyByName2(int pageNum, int pageSize, String disposeName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<ApplyAssets> pageInfo = new PageInfo<>(applyAssetsMapper.selectApplyByName2(disposeName));
        if(pageInfo.getTotal() != 0) {
            return ApplyResult.pagingApplyResult(pageSize,pageInfo);
        }else{
            return null;
        }
    }
    @Override
    public ApplyResult selectApplyByState(int pageNum, int pageSize, String applyState) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<ApplyAssets> pageInfo = new PageInfo<>(applyAssetsMapper.selectApplyByState(applyState));
        if(pageInfo.getTotal() != 0) {
            return ApplyResult.pagingApplyResult(pageSize,pageInfo);
        }else{
            return null;
        }
    }
    @Override
    public int addApplyAssets(ApplyAssets applyAssets) {
        return applyAssetsMapper.insertApplyAssets(applyAssets);
    }

    @Override
    public int deleteApplyById(int applyId) {
        return applyAssetsMapper.deleteApplyById(applyId);
    }
}
