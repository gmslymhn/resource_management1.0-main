package com.lc.demo.common;

import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.ApplyAssets;
import org.springframework.http.ResponseEntity;

/**
 * @author gmslymhn
 * @date 2023-08-04 23:13
 * @description:资金申请
 */

public class ApplyResult {
    private PageInfo<ApplyAssets> data;
    private int totalPages;
    private ResponseEntity<Void> responseEntity;

    public PageInfo<ApplyAssets> getData() {
        return data;
    }

    public void setData(PageInfo<ApplyAssets> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public ResponseEntity<Void> getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(ResponseEntity<Void> responseEntity) {
        this.responseEntity = responseEntity;
    }

    public static ApplyResult pagingApplyResult(int pageSize, PageInfo<ApplyAssets> pageInfo) {

        ApplyResult applyResult = new ApplyResult();

        // 获取总记录数和总页码
        long total = pageInfo.getTotal();
        int totalPages = (int) Math.ceil((double) total / pageSize);

        if (pageInfo != null) {
            applyResult.setResponseEntity(ResponseEntity.ok().build());
        } else {
            applyResult.setResponseEntity(ResponseEntity.notFound().build());
        }
        applyResult.setData(pageInfo);
        applyResult.setTotalPages(totalPages);
        return applyResult;
    }
}