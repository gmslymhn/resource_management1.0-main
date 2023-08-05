package com.lc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.ApplyAssets;
import com.lc.demo.bean.Report;
import com.lc.demo.mapper.MessageRemindingMapper;
import com.lc.demo.service.MessageRemindingService;
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
        int unprocessedReportNum = messageRemindingMapper.selectUnprocessedReportNum();
        return unprocessedReportNum;
    }

    @Override
    public int selectUnprocessedApplyAssetsNum() {
        int unprocessedApplyAssetsNum = messageRemindingMapper.selectUnprocessedApplyAssetsNum();
        return unprocessedApplyAssetsNum;
    }

    @Override
    public int getMessageQuantity() {
        return selectUnprocessedReportNum()+selectUnprocessedApplyAssetsNum();
    }


    @Override
    public MessageResultOfReport selectReportByGoodsState(int pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Report> pageInfo = new PageInfo<>(messageRemindingMapper.selectReportByGoodsState());
        MessageResultOfReport messageResultOfReport = MessageResultOfReport.pagingMessageResult(pageSize, pageInfo);
        return messageResultOfReport;
    }
    @Override
    public MessageResultOfApply selectApplyByApplyState(int pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<ApplyAssets> pageInfo = new PageInfo<>(messageRemindingMapper.selectApplyByApplyState());
        MessageResultOfApply messageResultOfApply = MessageResultOfApply.pagingMessageResult(pageSize, pageInfo);
        return messageResultOfApply;
    }


    @Override
    public int updateReportBySequenceId(Report report) {
        int updated = messageRemindingMapper.updateReportBySequenceId(report);
        return updated;
    }

    @Override
    public int updateApplyAssetsByApplyId(ApplyAssets applyAssets) {
        int updated = messageRemindingMapper.updateApplyAssetsByApplyId(applyAssets);
        return updated;
    }
}
