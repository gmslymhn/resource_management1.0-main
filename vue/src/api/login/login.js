// 对API进行统一管理
import requests from "@/api/requests";

const url = "/abc/login"

// 登录
/**
 * @URL /abc/login
 * @method post
 * @param useraccount,password
 */
export const login = ({useraccount,password}) => {
  return requests.post(url, {
    useraccount: useraccount,
    password: password
  }, {
    headers:{'Content-Type': 'application/x-www-form-urlencoded'}
  });
}
