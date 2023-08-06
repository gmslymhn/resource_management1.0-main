package common;

import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Assets;
import org.springframework.http.ResponseEntity;

public class AssetsPage {
    private PageInfo<Assets> data;
    private int totalPages;
    private ResponseEntity<Void> responseEntity;

    public PageInfo<Assets> getData() {
        return data;
    }

    public void setData(PageInfo<Assets> data) {
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

    public static  AssetsPage pagingAssetsResult(int pageSize, PageInfo<Assets> pageInfo) {
        AssetsPage assetsPage = new AssetsPage();

        // 获取总记录数和总页码
        long total =pageInfo.getTotal();
        int totalPages = (int) Math.ceil((double) total / pageSize);

        if(pageInfo != null){
            assetsPage.setResponseEntity(ResponseEntity.ok().build());
        }else{
            assetsPage.setResponseEntity(ResponseEntity.notFound().build());
        }
        assetsPage.setData(pageInfo);
        assetsPage.setTotalPages(totalPages);
        return assetsPage;
    }

}
