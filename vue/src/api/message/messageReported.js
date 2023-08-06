// 对API进行统一管理
import requests from "@/utils/requests";
import qs from 'qs'

const url = "/admin/messageReminding"


// ### [查询]未处理损坏上报消息条数
/**
 * @URL /admin/messageReminding/getUnprocessedReportNum
 * @method get
 * @param 
 */
export const unprocessedReportNum = () => {
  return requests.get(url + "/getUnprocessedReportNum")
}

// 查询未(待)处理物品损坏记录
/**
 * @URL /admin/messageReminding/getUnprocessedReport
 * @method get
 * @param pageNum   (一页固定七个)
 */
export const unprocessedReport = ({pageNum}) => {
  return requests.get(url + "/getUnprocessedReport",{
    params:{
      pageNum,
    }
  })
}

// 更新管理员处理(未处理的)损坏记录信息
/**
 * @URL /admin/messageReminding/UpdateProcessedReport,
 * @method post
 * @param sequenceId,disposeNameId,disposeName,disposeDescription,disposeResult
 */
export const updateProcessedReport = ({sequenceId,disposeNameId,disposeName,disposeDescription}) => {
  return requests.post(url + "/UpdateProcessedReport",qs.stringify({
    sequenceId,
    disposeNameId,
    disposeName,
    disposeDescription,
    goodsState: "已处理"
  }), {
    headers:{'Content-Type': 'application/x-www-form-urlencoded'}
  })
}