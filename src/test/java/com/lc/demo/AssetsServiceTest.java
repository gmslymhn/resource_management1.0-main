//package com.lc.demo;
//
//import com.lc.demo.bean.Assets;
//import com.lc.demo.mapper.AssetsMapper;
//import com.lc.demo.service.impl.AssetsServicelmpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//public class AssetsServiceTest {
//
//    @Mock
//    private AssetsMapper assetsMapper;
//
//    @InjectMocks
//    private AssetsServicelmpl assetsService;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testSelectAllAssets() {
//        // 模拟数据库返回的资产列表
//        Assets asset1 = new Assets(2,20,10,null, 0.5F,"hjk");
//        Assets asset2 = new Assets(2,20,10,null, 0.5F,"hjk");
//
//        List<Assets> mockAssetsList = Arrays.asList(asset1, asset2);
//
//        // 模拟资产Mapper的行为
//        when(assetsMapper.all()).thenReturn(mockAssetsList);
//
////         调用待测试的方法
//        List<Assets> result = assetsService.selectAllAssets();
//System.out.println(result);
////         验证结果是否正确
////        assertEquals(mockAssetsList, result);
//    }
//}
