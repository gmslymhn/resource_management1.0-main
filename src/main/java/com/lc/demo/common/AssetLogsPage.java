package com.lc.demo.common;

import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Assets_Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetLogsPage {
    private PageInfo<Assets_Log> data;
    private int totalPages;
    private ResponseEntity<Void> responseEntity;

    public PageInfo<Assets_Log> getData() {
        return data;
    }

    public void setData(PageInfo<Assets_Log> data) {
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

    public static  AssetLogsPage pagingAssetsLogResult(int pageSize, PageInfo<Assets_Log> pageInfo) {
        AssetLogsPage assetLogsPage = new AssetLogsPage();

        // 获取总记录数和总页码
        long total =pageInfo.getTotal();
        int totalPages = (int) Math.ceil((double) total / pageSize);

        if(pageInfo != null){
            assetLogsPage.setResponseEntity(ResponseEntity.ok().build());
        }else{
            assetLogsPage.setResponseEntity(ResponseEntity.notFound().build());
        }
        assetLogsPage.setData(pageInfo);
        assetLogsPage.setTotalPages(totalPages);
        return assetLogsPage;
    }

}
