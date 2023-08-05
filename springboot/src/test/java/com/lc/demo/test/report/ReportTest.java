package com.lc.demo.test.report;

import com.lc.demo.bean.Report;
import com.lc.demo.mapper.*;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * @Author y
 * @Date 2023/07/27 0:41
 * @Version
 */

@SpringBootTest

@RunWith(SpringJUnit4ClassRunner.class)
public class ReportTest {
   @Autowired
   private ReportMapper reportsMapper;

   @Test
   public void insertReport(){

     //Date time0 = new java.sql.Date(new java.util.Date().getTime());
//todo:测试：DateTimeLiteralExpression.DateTime 如何进行测试，可以与mysql中datatime进行匹配？
//      Date time = new Date;
   }
   @Test
   public void selectAllReportTest(){
      List<Report> reportList = reportsMapper.selectAllReport();
      reportList.forEach(System.out::println);
   }

   @Test
   public void selectReportByReportName(){
      String reportName = "被测试的一把椅子";
      List<Report> reportList = reportsMapper.selectReportByReportName(reportName);
      System.out.println(reportList);
      //todo:查询异常MyBatisSystemException
      // nested exception is org.apache.ibatis.executor.result.ResultMapException:
      // Error attempting to get column 'process_time'
      // from result set.
      // Cause: java.lang.IllegalArgumentException:
      // No enum constant
      // net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime.2023-07-27 02:49:48
   }
   @Test
   public void selectReportByDisposeName(){
      String disposeName = "未处理";
      List<Report> reportList = reportsMapper.selectReportByDisposeName(disposeName);
      System.out.println(reportList);

   }

   @Test
   public void deleteReportById(){
      int id = 1;
      int deleted = reportsMapper.deleteReportById(id);
      System.out.println(deleted);

   }



}


