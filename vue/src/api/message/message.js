// 对API进行统一管理
import requests from "@/api/requests";

const url = "/admin/messageReminding"

// 查询未处理信息条数
/**
 * @URL /admin/messageReminding/getMessageQuantity
 * @method get
 * @param 无
 */
export const messageQuantity = () => {
  return requests.get(url + "/getMessageQuantity")
}