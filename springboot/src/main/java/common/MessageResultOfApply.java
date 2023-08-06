package common;

import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.ApplyAssets;
import org.springframework.http.ResponseEntity;

/**
 * @Author y
 * @Date 2023/08/05 20:56
 * @Version
 */

public class MessageResultOfApply {
    /**
     *
     */
    private PageInfo<ApplyAssets> data;

    //private int totalPages;
    /**
     *
     */
    private ResponseEntity<Void> responseEntity;




    public PageInfo<ApplyAssets> getData() {
        return data;
    }

    public void setData(PageInfo<ApplyAssets> data) {
        this.data = data;
    }

//    public int getTotalPages() {
//        return totalPages;
//    }

//    public void setTotalPages(int totalPages) {
//        this.totalPages = totalPages;
//    }

    public ResponseEntity<Void> getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(ResponseEntity<Void> responseEntity) {
        this.responseEntity = responseEntity;
    }


    public static MessageResultOfApply pagingMessageResult(int pageSize, PageInfo<ApplyAssets> pageInfo) {

        MessageResultOfApply messageResultOfApply = new MessageResultOfApply();

        // 获取总记录数和总页码
        //long totalMessage = pageInfo.getTotal();

        int totalPages = (int) Math.ceil((double) pageInfo.getTotal() / pageSize);

        if (pageInfo != null) {
            messageResultOfApply.setResponseEntity(ResponseEntity.ok().build());
        } else {
            messageResultOfApply.setResponseEntity(ResponseEntity.notFound().build());
        }
        pageInfo.setPages(totalPages);
        messageResultOfApply.setData(pageInfo);
        //messageResultOfApply.setTotalPages(totalPages);
        return messageResultOfApply;
    }
}
