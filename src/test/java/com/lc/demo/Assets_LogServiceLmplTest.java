//package com.lc.demo;
//
//import com.lc.demo.bean.Assets_Log;
//import com.lc.demo.bean.Report;
//import com.lc.demo.mapper.AssetsMapper;
//import com.lc.demo.mapper.Assets_LogMapper;
//import com.lc.demo.service.ReportService;
//import com.lc.demo.service.impl.Assets_LogServiceLmpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class Assets_LogServiceLmplTest {
//
//    @Mock
//    private Assets_LogMapper assetsLogMapper;
//
//    @Mock
//    private AssetsMapper assetsMapper;
//
//    @Mock
//    private ReportService reportService;
//
//    @InjectMocks
//    private Assets_LogServiceLmpl assetsLogService;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testSelectAllAssets_Logs() {
//        // 模拟数据库返回的资产日志列表
//        Assets_Log log1 = new Assets_Log(/* 设置属性值 */);
//        Assets_Log log2 = new Assets_Log(/* 设置属性值 */);
//        List<Assets_Log> mockLogsList = new ArrayList<>();
//        mockLogsList.add(log1);
//        mockLogsList.add(log2);
//
//        // 模拟资产日志Mapper的行为
//        when(assetsLogMapper.selectAllLogs()).thenReturn(mockLogsList);
//
//        // 调用待测试的方法
//        List<Assets_Log> result = assetsLogService.selectAllAssets_Logs();
//
//        // 验证结果是否正确
//        assertEquals(mockLogsList, result);
//    }
//
////    @Test
////    public void testSelectAllAssets_LogsPaged() {
////        // 模拟数据库返回的资产日志列表
////        Assets_Log log1 = new Assets_Log(/* 设置属性值 */);
////        Assets_Log log2 = new Assets_Log(/* 设置属性值 */);
////        List<Assets_Log> mockLogsList = new ArrayList<>();
////        mockLogsList.add(log1);
////        mockLogsList.add(log2);
////
////        // 模拟资产日志Mapper的行为
////        when(assetsLogMapper.selectAllLogs()).thenReturn(mockLogsList);
////
////        // 调用待测试的方法
////        int pageNum = 1;
////        int pageSize = 10;
////        List<Assets_Log> result = assetsLogService.selectAllAssets_Logs(pageNum, pageSize).getList();
////
////        // 验证结果是否正确
////        assertEquals(mockLogsList, result);
////    }
//
//    @Test
//    public void testDeleteByAssets_Log() {
//        // 模拟要删除的资产日志ID
//        int assetsLogId = 1;
//
//        // 模拟资产日志Mapper的行为
//        Assets_Log mockAssetsLog = new Assets_Log(1,"o","l",4,null,4,4);
//        when(assetsLogMapper.selectByAssetsLog(assetsLogId)).thenReturn(mockAssetsLog);
//
//        // 调用待测试的方法
//        int result = assetsLogService.deleteByAssets_Log(assetsLogId);
//
//        // 验证是否调用了正确的方法
//        verify(assetsLogMapper).deleteByAssetsLog(assetsLogId);
//
//        // 验证结果是否正确
//        assertEquals(1, result);
//    }
//
////    @Test
////    public void testAddAssets_Log() {
////        // 模拟要添加的资产日志信息
////        int id = 1;
////        float change_assets = 100.0f;
////        String description = "Test description";
////
////        // 模拟ReportService的行为
////        Report mockReport = new Report(/* 设置属性值 */);
////        when(reportService.selectById(id)).thenReturn(mockReport);
////
////        // 模拟AssetsMapper的行为
////        Assets mockAssets = new Assets(/* 设置属性值 */);
////        when(assetsMapper.newAssets()).thenReturn(mockAssets);
////
////        // 调用待测试的方法
////        assetsLogService.addAssets_Log(id, change_assets, description);
////
////        // 验证是否调用了正确的方法
////        verify(assetsLogMapper).insertAssetsLog(any(Assets_Log.class));
////    }
//
//    @Test
//    public void testUpdate() {
//        // 模拟要更新的资产日志信息
//        Assets_Log assetsLogToUpdate = new Assets_Log(/* 设置属性值 */);
//
//        // 模拟资产日志Mapper的行为
//        Assets_Log mockAssetsLog = new Assets_Log(/* 设置属性值 */);
//        when(assetsLogMapper.selectByAssetsLog(assetsLogToUpdate.getAssetsLogId())).thenReturn(mockAssetsLog);
//
//        // 调用待测试的方法
//        int result = assetsLogService.update(assetsLogToUpdate);
//
//        // 验证是否调用了正确的方法
//        verify(assetsLogMapper).update(assetsLogToUpdate);
//
//        // 验证结果是否正确
//        assertEquals(1, result);
//    }
//
//    @Test
//    public void testSelectById() {
//        // 模拟要查询的资产日志ID
//        int assetsLogId = 1;
//
//        // 模拟资产日志Mapper的行为
//        Assets_Log mockAssetsLog = new Assets_Log(/* 设置属性值 */);
//        when(assetsLogMapper.selectByAssetsLog(assetsLogId)).thenReturn(mockAssetsLog);
//
//        // 调用待测试的方法
//        Assets_Log result = assetsLogService.selectById(assetsLogId);
//
//        // 验证结果是否正确
//        assertEquals(mockAssetsLog, result);
//    }
//
////    @Test
////    public void testSelectByName() {
////        // 模拟要查询的用户名和分页信息
////        String userName = "TestUser";
////        int pageNum = 1;
////        int pageSize = 10;
////
////        // 模拟资产日志Mapper的行为
////        List<Assets_Log> mockLogsList = new ArrayList<>();
////        when(assetsLogMapper.selectLogByUserName(userName)).thenReturn(mockLogsList);
////
////        // 调用待测试的方法
////        AssetLogsPage result = assetsLogService.selectByName(userName, pageNum, pageSize);
////
////        // 验证结果是否正确
////        assertEquals(mockLogsList, result.getList());
////    }
//
//    // 编写其他方法的测试用例...
//}
