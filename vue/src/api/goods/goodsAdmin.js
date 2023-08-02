// 对API进行统一管理
import requests from "@/api/requests";


// Vuex里在action中
// async userLogin({commit},data){
//   let result = await reqUserLogin(data)
// }


// 物品页面

const url = "/admin/admgoods"

// goods类
// Integer goodsId;     需要传int类型的id
// String goodsName;	  需要String类型的名称
// String goodsState;	  需要String类型的状态
// String goodsImage;	  这个是图片的url，你不需要给我传


// 展示物品
/**
 * @URL /admin/admgoods/getAllGoods
 * @method get
 * @param 页码pageNum,当前页码有几个pageSize
 */
export const itemsList = ({pageNum,pageSize}) => {
  return requests.get(url + "/getAllGoods",{
    params: {
      pageNum: pageNum,
      pageSize: pageSize
    }
  })
}

// 修改以及增加物品物品
/**
 * @URL /admin/admgoods/updateGoods
 * @method post
 * @param 第一个参数uploadImage是用input获取的文件，第二个参数名字是goods，他是一个Goods类
 */
export const itemsEdit = ({submitFormURL, goodsImage, formData}) => {
  return requests.post(url + `/addGoods${submitFormURL}`, {
    uploadImage: goodsImage,
    goods: formData
  }, {
    headers: { "Content-type": "multipart/form-data" }
  });
}

// 根据物品名查询上报信息
/**
 * @URL /admin/admgoods/selectGoodsByGoodsName
 * @method get
 * @param goodsName
 */
export const searchByGoodsNameFunc = ({goodsName}) => {
  return requests.get(url + "/selectGoodsByGoodsName",{
    params: {
      goodsName: goodsName,
    }
  });
}

// 删除物品
/**
 * @URL /admin/admgoods/deleteGoods
 * @method get
 * @param 第一个参数是goods，他是一个Goods类
 */
export const itemsRemove = ({goodsId}) => {
  return requests.get(url + "/deleteGoods",{
    params: {
      goodsId: goodsId
    }
  })
}