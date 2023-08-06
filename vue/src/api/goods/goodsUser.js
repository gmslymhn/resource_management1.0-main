// 对API进行统一管理
import requests from "@/api/requests";


// Vuex里在action中
// async userLogin({commit},data){
//   let result = await reqUserLogin(data)
// }


// 物品页面

const url = "/user/usegoods"

// goods类
// Integer goodsId;     需要传int类型的id
// String goodsName;	  需要String类型的名称
// String goodsState;	  需要String类型的状态
// String goodsImage;	  这个是图片的url，你不需要给我传


// 展示物品
/**
 * @URL /user/usegoods/getAllGoods 
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

// 增加物品
/**
 * @URL /user/usegoods/updateGoods
 * @method post
 * @param 第一个参数uploadImage是用input获取的文件，第二个参数名字是goods，他是一个Goods类
 */
export const itemsEdit = ({submitFormURL, formData}) => {
  return requests.post(url + `/${submitFormURL}`, {
    data: {
      formData: formData
    }
  }, {
    headers: { "Content-type": "multipart/form-data" }
  });
}

// 根据物品名查询上报信息
/**
 * @URL /user/usegoods/selectGoodsByGoodsName
 * @method post
 * @param pageNum,pageSize,goodsName
 */
export const searchByGoodsNameFunc = ({pageNum,pageSize,goodsName}) => {
  return requests.post(url + "/selectGoodsByGoodsName",{
      pageNum: pageNum,
      pageSize: pageSize,
      goodsName: goodsName,
  }, {
    headers: { "Content-type": "multipart/form-data" }
  });
} 