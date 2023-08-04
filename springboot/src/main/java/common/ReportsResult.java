package common;

import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Report;
import org.springframework.http.ResponseEntity;

public class ReportsResult {
    private PageInfo<Report> data;
    private int totalPages;
    private int total;
    private ResponseEntity<Void> responseEntity;

    public ReportsResult() {
    }
    

    public PageInfo<Report> getData() {
        return data;
    }

    public void setData(PageInfo<Report> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ResponseEntity<Void> getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(ResponseEntity<Void> responseEntity) {
        this.responseEntity = responseEntity;
    }
    public static ReportsResult pagingReportsResult(int pageSize, PageInfo<Report> pageInfo) {
        ReportsResult reportsResult = new ReportsResult();

        // 获取总记录数和总页码
        long total = pageInfo.getTotal();
        int totalPages = (int) Math.ceil((double) total / pageSize);

        if (pageInfo != null) {
            reportsResult.setResponseEntity(ResponseEntity.ok().build());
        } else {
            reportsResult.setResponseEntity(ResponseEntity.notFound().build());
        }
        reportsResult.setData(pageInfo);
        reportsResult.setTotalPages(totalPages);
        return reportsResult;
    }
}
