package com.lc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.Report;
import com.lc.demo.mapper.MessageRemindingMapper;
import com.lc.demo.service.MessageRemindingService;
import common.GoodsResult;
import common.MessageResultOfApply;
import common.MessageResultOfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author y
 * @Date 2023/08/04 14:53
 * @Version
 */
@Service
public class MessageRemindingServiceImpl implements MessageRemindingService {
    @Autowired
    private MessageRemindingMapper messageRemindingMapper;
    private final int pageSize = 7;
    @Override
    public int selectUnprocessedReportNum() {
        return messageRemindingMapper.selectUnprocessedReportNum();
    }

    @Override
    public int selectUnprocessedApplyAssetsNum() {
        return messageRemindingMapper.selectUnprocessedApplyAssetsNum();
    }

    @Override
    public int getMessageQuantity() {
        return selectUnprocessedReportNum()+selectUnprocessedApplyAssetsNum();
    }


    @Override
    public MessageResultOfReport selectReportByGoodsState(int pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Report> pageInfo = new PageInfo<>(messageRemindingMapper.selectReportByGoodsState());
        if(pageInfo.getTotal() != 0) {
            return MessageResultOfReport.pagingMessageResult(pageSize, pageInfo);
        }else{
            return null;
        }
    }
    @Override
    public MessageResultOfApply selectApplyByApplyState(int pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<ApplyAssets> pageInfo = new PageInfo<>(messageRemindingMapper.selectApplyByApplyState());
        if(pageInfo.getTotal() != 0) {
            return MessageResultOfApply.pagingMessageResult(pageSize, pageInfo);
        }else{
            return null;
        }
    }


    @Override
    public int updateReportBySequenceId(Report report) {
        return messageRemindingMapper.updateReportBySequenceId(report);
    }

    @Override
    public int updateApplyAssetsByApplyId(ApplyAssets applyAssets) {

        return messageRemindingMapper.updateApplyAssetsByApplyId(applyAssets);
    }
}
