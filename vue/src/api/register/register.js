// 对API进行统一管理
import requests from "@/api/requests";

const url = "/abc/register"

// 注册
/**
 * @URL /abc/login
 * @method post
 * @param report类
 */
export const register = ({useraccount,password,username,usernumber,userpost}) => {
  return requests.post(url, {
    useraccount: useraccount,
    password: password,
    username: username,
    usernumber: usernumber,
    userpost: userpost
  }, {
    headers:{'Content-Type': 'application/json'}
  });
}