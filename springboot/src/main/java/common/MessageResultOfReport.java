package common;

import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Report;
import org.springframework.http.ResponseEntity;

/**
 * @Author y
 * @Date 2023/08/06 0:45
 * @Version
 */

public class MessageResultOfReport {
   private PageInfo<Report> data;

//   private int totalPages;

   private ResponseEntity<Void> responseEntity;




   public PageInfo<Report> getData() {
      return data;
   }

   public void setData(PageInfo<Report> data) {
      this.data = data;
   }

//   public int getTotalPages() {
//      return totalPages;
//   }

//   public void setTotalPages(int totalPages) {
//      this.totalPages = totalPages;
//   }

   public ResponseEntity<Void> getResponseEntity() {
      return responseEntity;
   }

   public void setResponseEntity(ResponseEntity<Void> responseEntity) {
      this.responseEntity = responseEntity;
   }


   public static MessageResultOfReport pagingMessageResult(int pageSize, PageInfo<Report> pageInfo) {

      MessageResultOfReport messageResultOfReport = new MessageResultOfReport();

      // 获取总记录数和总页码
      //long total = pageInfo.getTotal();
      int totalPages = (int) Math.ceil((double) pageInfo.getTotal()/ pageSize);

      if (pageInfo != null) {
         messageResultOfReport.setResponseEntity(ResponseEntity.ok().build());
      } else {
         messageResultOfReport.setResponseEntity(ResponseEntity.notFound().build());
      }
      pageInfo.setPages(totalPages);
      messageResultOfReport.setData(pageInfo);
//      messageResultOfReport.setTotalPages(totalPages);
      return messageResultOfReport;
   }
}
