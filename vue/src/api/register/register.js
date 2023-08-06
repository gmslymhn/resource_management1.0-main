// 对API进行统一管理
import requests from "@/utils/requests";

const url = "/abc/register"

// 注册
/**
 * @URL /abc/register
 * @method post
 * @param report类
 */
export const register = ({userAccount,userPassword,userName,userNumber,userpost}) => {
  return requests.post(url, {
    userAccount: userAccount,
    userPassword: userPassword,
    userName: userName,
    userNumber: userNumber,
    userpost: userpost
  }, {
    headers:{'Content-Type': 'application/json'}
  });
}