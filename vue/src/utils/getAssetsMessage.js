import { unprocessedApplyAssetsNum } from "@/api/message/messageAssets"
// [查询]未处理损坏上报消息条数
async function getUnprocessedAssetsNum(){
  let resAssets = await unprocessedApplyAssetsNum()
  console.log("未处理资金申请信息条数-----",resAssets);
  return resAssets
}

export default getUnprocessedAssetsNum