// 消息查询
import { messageQuantity } from "@/api/message/message"

// 消息查询
async function getMessageQuantity(that){
  let resMessageAll = await messageQuantity();
  console.log("消息查询操作-----", resMessageAll);
  let messageNum = resMessageAll.data.code;
  if(messageNum){
    that.$notify.info({
      title: '消息',
      message: '您有待审批消息',
      offset: 70
    });
  }
}

export default getMessageQuantity;

