/**
 * Copyright (C), 2000-2023, XXX有限公司
 * FileName: ImageServiceImpl
 * Author: 22932
 * Date: 2023/7/24 17:27:24
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.lc.demo.service.impl;

import com.lc.demo.bean.Goods;
import com.lc.demo.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName: ImageServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2023/7/24 17:27:24
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public void saveGoodsImage(MultipartFile uploadImage, Goods goods) {
        // 处理上传的图片文件，保存到合适的位置
        // 例如，可以使用UUID生成唯一的文件名
        String fileName = UUID.randomUUID().toString() + ".jpg";
        String filePath = System.getProperty("user.dir") + "\\springboot\\src\\main\\resources\\goodsImage\\" + fileName;
        System.out.println(filePath);
        try {
            uploadImage.transferTo(new File(filePath));
            goods.setGoodsImage( "/goodsImage/" + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

