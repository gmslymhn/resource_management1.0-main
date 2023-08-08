// 对API进行统一管理
import requests from "@/api/requests";


// Vuex里在action中
// async userLogin({commit},data){
//   let result = await reqUserLogin(data)
// }


// 物品页面

const url = "admgoods"

// goods类
// Integer goodsId;      需要传int类型的id
// String goodsName;	  需要String类型的名称
// String goodsState;	  需要String类型的状态
// String goodsImage;	  这个是图片的url，你不需要给我传


// 展示物品
/**
 * @URL /admin/admgoods/getAllGoods 
 * @method get
 * @param 页码page
 */
export const itemsList = ({page}) => {
  requests.get(url + "/getAllGoods",{
    params: {
      page: page
    }
  })
}

// 修改以及增加物品物品
/**
 * @URL /admin/admgoods/updateGoods
 * @method post
 * @param 第一个参数uploadImage是用input获取的文件，第二个参数名字是goods，他是一个Goods类
 */
export const itemsEdit = (submitFormURL, goodsImage, formData) => {
  return requests.post(url + `/addGoods${submitFormURL}`, {
    uploadImage: goodsImage,
    goods: formData
  }, {
    headers: { "Content-type": "multipart/form-data" }
  });
}

// 删除物品
/**
 * @URL /admin/admgoods/deleteGoods
 * @method get
 * @param 第一个参数是goods，他是一个Goods类
 */
export const itemsRemove = ({goodsId}) => {
  requests.get(url + "/deleteGoods",{
    params: {
      goodsId: goodsId
    }
  })
}