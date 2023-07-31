// 对API进行统一管理
import requests from "@/api/requests";

const url = "admReport"

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
 * @param 无
 */
export const reportList = () => {
  requests.get(url + "/getALLReport")
}

// 根据物品id查询上报信息
/**
 * @URL /admin/admReport/selectById
 * @method get
 * @param goodId
 */
export const searchByIdFunc = ({id}) => {
  requests.get(url + "/selectById",{
    params: {
      goodId: id
    }
  });
}

// 根据上报人查询上报信息
/**
 * @URL /admin/admReport/selectByReportName
 * @method get
 * @param reportName
 */
export const searchByReportNameFunc = ({reportName}) => {
  requests.get(url + "/selectByReportName",{
    params: {
      reportName: reportName
    }
  });
}

// 根据处理人查询上报信息
/**
 * @URL /admin/admReport/selectByDisposeName
 * @method get
 * @param disposeName
 */
export const searchByDisposeNameFunc = ({disposeName}) => {
  requests.get(url + "/selectByDisposeName",{
    params: {
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
export const damageReported = (items) => {
  return requests.post(url + "/admgoods/addGoods/", {
    report: items
  });
}

// 根据物品id删除上报数据
/**
 * @URL /admin/admReport/deleteReport
 * @method get
 * @param goodId
 */
export const deleteGoods = (id) => {
  return requests.get(url + "/deleteReport", {
    params: {
      goodId: id
    }
  })
}