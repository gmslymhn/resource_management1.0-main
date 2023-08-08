/**
 * Copyright (C), 2000-2023, XXX有限公司
 * FileName: ImageService
 * Author: 22932
 * Date: 2023/7/24 14:44:04
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.lc.demo.service;

import com.lc.demo.bean.Goods;
import org.springframework.web.multipart.MultipartFile;


/**
 * @ClassName: ImageService
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2023/7/24 14:44:04
 */

public interface ImageService {
     /**
      * 保存物品图片，并将url设置到Goods的goodsImage上
      * @param uploadImage
      * @param goods
      */
     void saveGoodsImage(MultipartFile uploadImage,Goods goods) ;
}

