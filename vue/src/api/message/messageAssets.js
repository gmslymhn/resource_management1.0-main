// 对API进行统一管理
import requests from "@/api/requests";

const url = "/admin/messageReminding"

// 查询未(待)处理资金申请记录
/**
 * @URL /admin/messageReminding/getUnprocessedApply
 * @method get
 * @param pageNum   (一页固定七个)
 */
export const unprocessedApply = ({pageNum}) => {
  return requests.get(url + "/getUnprocessedApply",{
    params:{
      pageNum: pageNum,
    }
  }
  )
}

// 更新管理员处理(未处理的)损坏记录信息
/**
 * @URL /admin/messageReminding/UpdateProcessedApply
 * @method post
 * @param applyId,disposeName,disposeResult
 */
export const updateProcessedApply = ({applyId,disposeName,disposeNameId,applyState,disposeDescription}) => {
  return requests.post(url + "/UpdateProcessedApply",{
    applyId: applyId,
    disposeName: disposeName,
    disposeNameId: disposeNameId,
    applyState: applyState,
    disposeDescription: disposeDescription
  }, {
    headers:{'Content-Type': 'application/json'}
  })
}