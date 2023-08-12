// 对API进行统一管理
import requests from "@/utils/requests";
import qs from 'qs'

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
 * @method post
 * @param 页码pageNum,当前页码有几个pageSize
 */
export const itemsList = ({pageNum,pageSize}) => {
  return requests.post(url + "/getAllGoods",qs.stringify({
      pageNum,
      pageSize
  }),{
    headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
  },{
    responseType: 'arraybuffer',
  });
}

// 增加物品
/**
 * @URL /admin/admgoods/addGoods
 * @method post
 * @param 第一个参数uploadImage是用input获取的文件，第二个参数名字是goods，他是一个Goods类
 */
export const itemsAdd = ({formData}) => {
  return requests.post(url + "/addGoods", {
      uploadImage: formData.get("uploadImage"),
      goodsName: formData.get("goodsName"),
      goodsQuantity: formData.get("goodsQuantity"),
      goodsState: formData.get("goodsState"),
    }, {
      headers: { "Content-type": "multipart/form-data" }
  });
}


// 修改物品
/**
 * @URL /admin/admgoods/updateGoods
 * @method post
 * @param 第一个参数uploadImage是用input获取的文件，第二个参数名字是goods，他是一个Goods类
 */
export const itemsEdit = ({formData}) => {
  return requests.post(url + "/updateGoods", {
    uploadImage: formData.get("uploadImage"),
    goodsId: formData.get("goodsId"),
    goodsName: formData.get("goodsName"),
    goodsState: formData.get("goodsState"),
  }, {
    headers: { "Content-type": "multipart/form-data" }
  });
}

// 根据物品名查询上报信息
/**
 * @URL /admin/admgoods/selectGoodsByGoodsName
 * @method get
 * @param pageNum,pageSize,goodsName
 */
export const searchByGoodsNameFunc = ({pageNum,pageSize,goodsName}) => {
  return requests.post(url + "/selectGoodsByGoodsName",qs.stringify({
      pageNum,
      pageSize,
      goodsName,
  }),{
    headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
  },{
    responseType: 'arraybuffer',
  });
}

// 根据物品id查询上报信息
/**
 * @URL /admin/admgoods/selectGoodsById
 * @method get
 * @param goodsId
 */
export const searchByGoodsIdFunc = ({goodsId}) => {
  return requests.post(url + "/selectGoodsById",qs.stringify({
    goodsId,
  }),{
    headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
  });
}


// 删除物品
/**
 * @URL /admin/admgoods/deleteGoods
 * @method get
 * @param goodsId
 */
export const itemsRemove = ({goodsId}) => {
  return requests.get(url + "/deleteGoods",{
    params: {
      goodsId
    }
  });
}