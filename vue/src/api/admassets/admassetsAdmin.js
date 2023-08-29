import requests from "@/utils/requests";

const url = "admassets"

// 修改可用资产的百分比
/**
 * @URL /admin/admassets/assets/update
 * @method get
 * @params 必选参数：percentage:百分比
 */
export const changePercentage = (percentage) => {
  requests.get(url + 'assets/update', {
    params: {
      percentage
    }
  })
}


//查询所有assets
/**
 * @URL /admin/admassets/assets
 * @method get
 * @params 必选参数: 无
 */
export const getAllAssets = () => {
  requests.get(url + 'assets')
}

//查询new_assets
/**
 * @URL /admin/admassets/assets/new
 * @method get
 * @params 必选参数: 无
 */
export const getAllNewAssets = () => {
  requests.get(url + 'assets/new')
}

