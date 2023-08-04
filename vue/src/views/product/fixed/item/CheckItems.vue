<template>
  <div class="checkItems">

    <div class="itemsText">
      <p class="itemsTextP">物品展示</p>
    </div>

    <el-button class="itemsButton" type="text" @click="itemsButton">添加新物品</el-button>
    
    <!-- 添加新物品弹窗 和 编辑物品弹窗 -->
    <el-dialog :title="dialogFormVisibleTitle" :visible.sync="dialogFormVisible" :append-to-body="true" class="itemsDialog">
      <el-form :model="items" :rules="rules" ref="items" label-width="100px" class="demo-ruleForm">
        <el-form-item label="物品名称" prop="goodsName">
          <el-input v-model="items.goodsName"></el-input>
        </el-form-item>
        <el-form-item label="物品状态" prop="goodsState">
          <el-radio-group v-model="items.goodsState">
            <el-radio label="已使用"></el-radio>
            <el-radio label="未使用"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="上传图片" prop="goodsImage">
          <el-upload
            class="itemsImg"
            drag
            action="abcd"
            list-type	="picture"
            :on-change="changeFile">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将物品照片拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>  
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitButton('rules')">确 定</el-button>
        <el-button @click="dialogFormVisible = false">取 消</el-button>
      </div>

    </el-dialog>

    <!-- 展示页面 -->
    <el-table :data="tableData" border align="center" class="itemsTable" :header-cell-style="{'text-align':'center'}">
        <el-table-column prop="id" label="物品id" align='center'></el-table-column>
        <el-table-column prop="image" label="物品照片" align='center'>
            <template slot-scope="scope">
                <img style="width:80px;height:80px" :src="scope.row.image">
            </template>
        </el-table-column>
        <el-table-column prop="name" label="物品名称" align='center'></el-table-column>
        <el-table-column prop="state" label="物品状态" align='center'></el-table-column>
        <el-table-column label="操作" align='center'>
            <template slot-scope="scope">
                <el-button type="success" @click="editClick(scope.$index,scope.row)" size="mini">编辑</el-button>
                <el-button type="danger" @click="removeClick(scope.$index,scope.row)" size="mini">删除</el-button>
            </template>
        </el-table-column>
    </el-table>

    <!-- 分页 -->
    <div class="pagination">
      <Pagination :total="total" :pageSize="pageSize" @currentChange="currentChange"></Pagination>
    </div>

  </div>
</template>

<script>
import Pagination from '@/components/pagination/Pagination';
import { itemsList,itemsRemove,itemsEdit } from '@/api/admgoods/admgoods.js'
export default {
  name: 'Content-CheckItems',
  components:{Pagination,},
  data() {
    const validateLogo = (rule, value, callback) => {
      if (!this.items.goodsImage) {
        callback(new Error('请上传图片'))
      } else {
        callback()
      }
    }
    return {
      formLabelWidth: '120px',
      tableData: [{
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }, {
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }, {
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }, {
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }, {
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }, {
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }, {
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }, {
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }, {
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }, {
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }, {
        id:"001",
        image: "https://pic3.zhimg.com/80/v2-cc3236b4e6b192e8a3f75a358b706582_720w.webp",
        state:"已使用",
        name: '王小虎',
      }],
      // 控制弹窗
      dialogFormVisible: false,
      // 弹窗标题
      dialogFormVisibleTitle: "",
      // 添加物品
      items: {
        goodsId: '',
        goodsName: '',
        goodsState: '',
        goodsImage: '',
      },
      // 暂存图片
      fileList:[],
      // 添加物品规则
      rules: {
        goodsName: [
          { required: true, message: '请输入物品名称', trigger: 'blur' },
        ],
        goodsState: [
          { required: true, message: '请选择物品状态', trigger: 'change' }
        ],
        goodsImage: [
          { required: true, validator: validateLogo, trigger: 'change' }
        ],
      },
      // 关于页码
      // 总共条数
      total: 100,
      // 页码数量
      pageSize: 10,
      // 当前页码
      currentPage: 1,
    };
  },
  methods: {
    // 获取物品列表数据接口
    async getItemsList(page){
      let res = await itemsList({page})
      console.log("产品列表数据-----",res.data)
      // 列表赋值
      this.tableData = res.data.data
      this.total = res.data.total
      this.pageSize = res.data.pageSize
    },

    // 添加新物品接口/修改接口
    async postItemsEdit(submitFormURL, img, goods){
      let res = await itemsEdit({submitFormURL, img, goods})
      console.log("修改/增加产品列表-----",res.data);
      // 重新获取列表
      this.getItemsList(this.currentPage)
    },

    // 删除接口
    async getItemsRemove(id){
      let res = await itemsRemove({id})
      console.log("产品列表数据-----",res.data)
      if(res.data.status === 200){
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
        // 重新获取列表
        this.getItemsList(this.currentPage)
      }
    },
    // 更新页码
    currentChange(val){
      console.log("更新页码-----",val);
      this.currentPage = val
      this.getItemsList(val)
    },
    // 修改
    editClick(index, row) {
      console.log("修改操作-----",index, row);
      // 触发弹窗
      this.dialogFormVisible = true
      // 将弹窗标题修改
      this.dialogFormVisibleTitle = "修改物品数据"
      // 往表单填数据
      this.items.goodsName = row.name
      this.items.goodsState = row.state
      // 发送请求
      this.$refs.items.validate((valid) => {
        if (valid) {
          console.log("validate-----",this.$refs.items);
          this.submitForm("deleteGoods")
        } else {
          console.log('error submit!!');
          return false;
        }
      });
      
    },
    // 删除
    removeClick(index, row) {
      console.log("删除操作-----",index, row);
      this.$confirm('此操作将删除该物品, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.getItemsRemove(row.id)
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });          
      });
    },
    
    // 提交新物品的大按钮
    itemsButton(){
      // 触发弹窗
      this.dialogFormVisible = true;
      // 将弹窗标题修改
      this.dialogFormVisibleTitle = '添加新物品'
      // 表单数据清空
      this.items.goodsName = ""
      this.items.goodsState = ""
    },
    // 提交新物品
    submitButton(items) {
      this.$refs.items.validate((valid) => {
        if (valid) {
          console.log("validate-----",this.$refs.items);
          this.submitForm("addGoods")
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    // 获取图片对象
    changeFile(file, fileList) {
      console.log(fileList);
      // 选择文件后，给fileList对象赋值
      this.fileList = fileList
    },
    // 正式提交新物品 和 修改物品
    submitForm(submitFormURL){
      let formData = new FormData()
      this.items.goodsImage = this.fileList[0].raw
      console.log(this.fileList[0].raw)
      // 将form表单中的值都赋值给FormData传递给后台
      for(let key in this.items){
        console.log(this.items[key])
        formData.append(key,this.items[key])
      }
      // 删除Image
      delete formData.goodsImage
      // 发送请求
      this.postItemsEdit(submitFormURL, this.items.goodsImage, formData)
    }
  },
  created() {
    this.getItemsList(this.currentPage)
  },
};
</script>

<style scoped>
  .checkItems{
    width: 100%;
    height: 100%;
    position: relative;
    overflow-y: scroll;
  }
  .itemsText{
    font-size: 38px;
    margin-bottom: 20px;
    padding-top: 2px;
    padding-bottom: 3px;
    background-color: #e0dbdb;
    font-weight: bold;
    color: gray;
    text-align: center;
    position: fixed;
    width: 100%;
    box-shadow: rgba(50, 50, 93, 0.25) 0px 30px 60px -12px, rgba(0, 0, 0, 0.3) 0px 18px 36px -18px;
    z-index: 1;
  }
  .itemsButton{
    margin-top: 60px;
    font-size: 18px;
    position: fixed;
    left: 0px;
    background-color: aliceblue;
    z-index: 1;
  }
  .itemsImg{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  .itemsTable{
    margin-top: 110px;
    background-color: transparent;
  }
  ::v-deep .el-table th,
  ::v-deep .el-table tr,
  ::v-deep .el-table td {
    background-color: rgba(255, 255, 255, 0.637) !important;
  }
  /* 去除底部白线 */
  .el-table::before{
    background-color: transparent;
  }
  .pagination{
    padding-top: 10px;
    padding-bottom: 10px;
    margin-bottom: 10px;
    background-color: rgba(255, 255, 255, 0.815) !important;
  }
</style>