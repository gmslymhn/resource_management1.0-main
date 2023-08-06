// 对API进行统一管理
import requests from "@/utils/requests";
import qs from 'qs'

const url = "/admin/messageReminding"

// ### [查询]未处理资金申请消息条数
/**
 * @URL /admin/messageReminding/getUnprocessedApplyAssetsNum
 * @method get
 * @param 
 */
export const unprocessedApplyAssetsNum = () => {
  return requests.get(url + "/getUnprocessedApplyAssetsNum")
}

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
  return requests.post(url + "/UpdateProcessedApply",qs.stringify({
    applyId: applyId,
    applyState: applyState,
    disposeNameId: disposeNameId,
    disposeName: disposeName,
    disposeDescription: disposeDescription,
  }), {
    headers:{'Content-Type': 'application/x-www-form-urlencoded'}
  })
}