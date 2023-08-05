package com.lc.demo.common; /**
 * Copyright (C), 2000-2023, XXX有限公司
 * FileName: Result
 * Author: 22932
 * Date: 2023/7/27 10:32:19
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */


import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Goods;
import org.springframework.http.ResponseEntity;

/**
 * @ClassName: Result
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2023/7/27 10:32:19
 */
public class GoodsResult {
    private PageInfo<Goods> data;
    private int totalPages;
    private ResponseEntity<Void> responseEntity;

    public PageInfo<Goods> getData() {
        return data;
    }

    public void setData(PageInfo<Goods> data) {
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

    public static GoodsResult pagingGoodsResult(int pageSize, PageInfo<Goods> pageInfo) {
        GoodsResult goodsResult = new GoodsResult();

        // 获取总记录数和总页码
        long total =pageInfo.getTotal();
        int totalPages = (int) Math.ceil((double) total / pageSize);

        if(pageInfo != null){
            goodsResult.setResponseEntity(ResponseEntity.ok().build());
        }else{
            goodsResult.setResponseEntity(ResponseEntity.notFound().build());
        }
        goodsResult.setData(pageInfo);
        goodsResult.setTotalPages(totalPages);
        return goodsResult;
    }
}