import { unprocessedReportNum } from "@/api/message/messageReported"
// [查询]未处理损坏上报消息条数
async function getUnprocessedReportNum(){
  let resReported = await unprocessedReportNum()
  console.log("未处理损坏物品信息条数-----",resReported);
  return resReported
}

export default getUnprocessedReportNum