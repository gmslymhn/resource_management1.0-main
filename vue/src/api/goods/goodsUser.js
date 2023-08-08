// 对API进行统一管理
import requests from "@/utils/requests";
import qs from 'qs'

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
 * @method post
 * @param 页码pageNum,当前页码有几个pageSize
 */
export const itemsList = ({pageNum,pageSize}) => {
  return requests.post(url + "/getAllGoods",qs.stringify({
      pageNum: pageNum,
      pageSize: pageSize
  }),{
    headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
  },{
    responseType: 'arraybuffer',
  });
}

// 根据物品id查询上报信息
/**
 * @URL /user/usegoods/selectGoodsById
 * @method get
 * @param goodsId
 */
export const searchByGoodsIdFunc = ({goodsId}) => {
  return requests.post(url + "/selectGoodsById",qs.stringify({
    goodsId,
  }),{
    headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
  },{
    responseType: 'arraybuffer',
  });
}

// 根据物品名查询上报信息
/**
 * @URL /user/usegoods/selectGoodsByGoodsName
 * @method post
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
