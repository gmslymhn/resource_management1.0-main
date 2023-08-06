// 对API进行统一管理
import requests from "@/api/requests";

const url = "/admin/messageReminding"

// 查询未(待)处理物品损坏记录
/**
 * @URL /admin/messageReminding/getUnprocessedReport
 * @method get
 * @param pageNum   (一页固定七个)
 */
export const unprocessedReport = ({pageNum}) => {
  return requests.get(url + "/getUnprocessedReport",{
    params:{
      pageNum: pageNum,
    }
  }
  )
}

// 更新管理员处理(未处理的)损坏记录信息
/**
 * @URL /admin/messageReminding/UpdateProcessedReport
 * @method post
 * @param sequenceId,disposeNameId,disposeName,disposeDescription
 */
export const updateProcessedReport = ({sequenceId,disposeNameId,disposeName,disposeDescription,}) => {
  return requests.post(url + "/UpdateProcessedReport",{
    sequenceId: sequenceId,
    disposeNameId: disposeNameId,
    disposeName: disposeName,
    disposeDescription: disposeDescription,
    goodsState: "已处理"
  }, {
    headers:{'Content-Type': 'application/json'}
  })
}