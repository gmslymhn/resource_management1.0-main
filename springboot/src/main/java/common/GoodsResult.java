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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Result
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2023/7/27 10:32:19
 */
import com.github.pagehelper.PageInfo;
import com.lc.demo.bean.Goods;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

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
    private List<ResponseEntity<byte[]>> responseEntityList;

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

    public List<ResponseEntity<byte[]>> getResponseEntityList() {
        return responseEntityList;
    }

    public void setResponseEntityList(List<ResponseEntity<byte[]>> responseEntityList) {
        this.responseEntityList = responseEntityList;
    }

    /**
     * 返回一个物品结果集，包含一页的数据，数据对应的图片数据，总页码
     * @param pageSize
     * @param pageInfo
     * @return
     */
    public static GoodsResult pagingGoodsResult(int pageNum,int pageSize, PageInfo<Goods> pageInfo) {
        GoodsResult goodsResult = new GoodsResult();

        // 获取总记录数和总页码
        long total =pageInfo.getTotal();
        int totalPages = (int) Math.ceil((double) total / pageSize);

        List<Goods> goodsList = pageInfo.getList();
        List<ResponseEntity<byte[]>> responseEntityList = new ArrayList<ResponseEntity<byte[]>>();

        if(pageNum != totalPages){
            for (int i = 0; i < pageSize; i++){
                responseEntityList.add(ProcessPictures(goodsList.get(i)));
            }
        }else{
            for (int i = 0; i < total-pageSize*(totalPages-1); i++){
                responseEntityList.add(ProcessPictures(goodsList.get(i)));
            }
        }


        goodsResult.setResponseEntityList(responseEntityList);
        goodsResult.setData(pageInfo);
        goodsResult.setTotalPages(totalPages);
        return goodsResult;
    }


    /**
     * 将url转为图片数据
     * @param goods
     * @return
     */
    public static ResponseEntity<byte[]> ProcessPictures(Goods goods){
        String goodsImage = goods.getGoodsImage();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\springboot\\src\\main\\resources"+goodsImage);
            byte[] bytes = new byte[1024];
            int b;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while((b = fileInputStream.read(bytes)) != -1){
                byteArrayOutputStream.write(bytes,0,b);
            }
            return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

