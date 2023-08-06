// 对API进行统一管理
import requests from "@/api/requests";

const url = "/admin/admReport"

// report类
// String reportName;												        需要传String类型的上报人名称	
// int goodsId;													            需要传int类型的物品id
// String goodsName;												        物品名称，不需要传
// String damageDescription;										    需要传String类型的损坏描述
// DateTimeLiteralExpression.DateTime reportTime;		上报时间					
// DateTimeLiteralExpression.DateTime processTime;	处理时间
// int goodsState;													        状态
// String disposeName;												      需要传String类型的处理人 


// 获取上报信息
/**
 * @URL /admin/admReport/getALLReport
 * @method get
 * @param pageNum,pageSize
 */
export const reportList = ({pageNum,pageSize}) => {
  return requests.get(url + "/getALLReport",{
    params:{
      pageNum: pageNum,
      pageSize: pageSize
    }
  })
}

// 根据上报人查询上报信息
/**
 * @URL /admin/admReport/selectByReportName
 * @method get
 * @param pageNum,pageSize,reportName
 */
export const searchByReportNameFunc = ({pageNum,pageSize,reportName}) => {
  return requests.get(url + "/selectByReportName",{
    params: {
      pageNum: pageNum,
      pageSize: pageSize,
      reportName: reportName
    }
  });
}

// 根据处理人查询上报信息
/**
 * @URL /admin/admReport/selectByDisposeName
 * @method get
 * @param pageNum,pageSize,disposeName
 */
export const searchByDisposeNameFunc = ({pageNum,pageSize,disposeName}) => {
  return requests.get(url + "/selectByDisposeName",{
    params: {
      pageNum: pageNum,
      pageSize: pageSize,
      disposeName: disposeName
    }
  });
}

// 提交损坏物品
/**
 * @URL /admin/admReport/addReport
 * @method post
 * @param report类
 */
export const damageReported = ({items}) => {
  return requests.post(url + "/addReport", {
    data: {
      report: items
    }
  });
}

// 根据上报信息id删除上报数据
/**
 * @URL /admin/admReport/deleteReport
 * @method get
 * @param sequenceId
 */
export const deleteGoods = ({sequenceId}) => {
  return requests.get(url + "/deleteReport", {
    params: {
      sequenceId: sequenceId
    }
  })
}