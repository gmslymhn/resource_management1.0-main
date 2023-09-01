/**
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
package common;

import com.github.pagehelper.PageInfo;

import com.lc.demo.bean.Goods;
import org.apache.ibatis.io.Resources;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sun.applet.Main;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @ClassName: Result
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2023/7/27 10:32:19
 */
public class GoodsResult {
    private PageInfo<Goods> data;
    private int totalPages;
    //    private ResponseEntity<byte[]>[] responseEntity;


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



    /**
     * 返回一个物品结果集，包含一页的数据，数据对应的图片数据，总页码
     * @param pageSize
     * @param pageInfo
     * @return
     */
    public static GoodsResult pagingGoodsResult(int pageSize, PageInfo<Goods> pageInfo) {
        GoodsResult goodsResult = new GoodsResult();

        // 获取总记录数和总页码
        long total =pageInfo.getTotal();
        int totalPages = (int) Math.ceil((double) total / pageSize);


        goodsResult.setData(pageInfo);
        goodsResult.setTotalPages(totalPages);
        return goodsResult;
    }




}

