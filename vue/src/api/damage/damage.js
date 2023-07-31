// 对API进行统一管理
import requests from "@/api/requests";

const url = "xxx"

// 提交损坏物品
/**
 * @URL /admin/admgoods/updateGoods
 * @method post
 * @param 第一个参数uploadImage是用input获取的文件，第二个参数名字是goods，他是一个Goods类
 */
export const damageReported = (items) => {
  return requests.post(url + "/admgoods/addGoods/", {
    goods: items
  });
}

// 物品损坏列表 
/**
 * @URL /admin/admgoods/getAllGoods 
 * @method get
 * @params 页码page
 */
export const itemsList = ({page}) => {
  requests.get(url + "/getAllGoods",{
    params: page,
  })
}