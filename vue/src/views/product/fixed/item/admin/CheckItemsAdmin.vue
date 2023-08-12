<template>
  <div class="checkItems">

    <div class="itemsText">
      <p class="itemsTextP">物品展示</p>
    </div>

    <el-button class="itemsButton" type="text" @click="itemsButton">添加新物品</el-button>


    <!-- 添加新物品弹窗 -->
    <el-dialog :title="dialogFormVisibleTitle" :visible.sync="dialogFormVisibleAdd" :append-to-body="true" class="itemsDialog">
      <el-form :model="items" :rules="rules" ref="items" label-width="100px" class="demo-ruleForm">
        <el-form-item label="物品名称" prop="goodsName">
          <el-input v-model="items.goodsName"></el-input>
        </el-form-item>
        <el-form-item label="物品数量" prop="goodsQuantity">
          <el-input v-model.number="items.goodsQuantity"></el-input>
        </el-form-item>
        <el-form-item label="物品状态" prop="goodsState">
          <el-radio-group v-model="items.goodsState">
            <el-radio label="未损坏"></el-radio>
            <el-radio label="已损坏"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="上传图片(限定一张)" prop="goodsImage">
          <!-- <el-upload
            class="itemsImg"
            drag
            :limit="1"
            action="http://172.16.1.3:8080/admin/admgoods/addGoods"
            list-type="picture"
            name="uploadImage"
            :on-change="changeFile">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将物品照片拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件,且不超过500kb</div>
          </el-upload> -->
          <el-upload
            class="itemsImg"
            ref="upload"
            drag
            :auto-upload="false"
            :limit="1"
            action="null"
            list-type="picture"
            :file-list="files"
            :on-change="changeFile">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将物品照片拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件,且不超过500kb</div>
          </el-upload>
        </el-form-item>  
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitButton('items')">确 定</el-button>
        <el-button @click="dialogFormVisibleAdd = false">取 消</el-button>
      </div>

    </el-dialog>

    <!-- 编辑物品弹窗 -->
    <el-dialog :title="dialogFormVisibleTitle" :visible.sync="dialogFormVisibleEdit" :append-to-body="true" class="itemsDialog">
      <el-form :model="items" :rules="rules" ref="items" label-width="100px" class="demo-ruleForm">
        <el-form-item label="物品id" prop="goodsId">
          <el-input  v-model="items.goodsId" :disabled="true">
          </el-input>
        </el-form-item>
        
        <el-form-item label="物品名称" prop="goodsName">
          <el-input v-model="items.goodsName"></el-input>
        </el-form-item>
        <el-form-item label="物品状态" prop="goodsState">
          <el-radio-group v-model="items.goodsState">
            <el-radio label="未损坏"></el-radio>
            <el-radio label="已损坏"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="上传图片(限定一张)" prop="goodsImage">
          <el-upload
            class="itemsImg"
            ref="upload"
            drag
            :auto-upload="false"
            :limit="1"
            action="null"
            list-type="picture"
            :file-list="files"
            :on-change="changeFile">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将物品照片拖到此处，或<em>点击上传</em></div>
          </el-upload>
        </el-form-item>  
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editClickButton('items')">确 定</el-button>
        <el-button @click="dialogFormVisibleEdit = false">取 消</el-button>
      </div>

    </el-dialog>

    <!-- 上报列表弹窗 -->
    <el-dialog title="上报" :visible.sync="dialogFormVisibleReported" :append-to-body="true" class="itemsDialog">
      
      <el-form :model="report" :rules="rules" ref="report" class="demo-ruleForm">
        <el-form-item label="上报人id" prop="reportNameId">
          <el-input v-model="report.reportNameId" :disabled="true"></el-input>
        </el-form-item>

        <el-form-item label="上报人姓名" prop="reportName">
          <el-input v-model.number="report.reportName" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="物品id" prop="goodsId">
          <el-input v-model.number="report.goodsId" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="损坏描述" prop="damageDescription">
          <el-input type="textarea" v-model="report.damageDescription"></el-input>
        </el-form-item>
        <el-button type="primary" @click="submitFormReport('rules')">上 报</el-button>
      </el-form>

      
        
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisibleReported = false">关 闭</el-button>
      </div>
    </el-dialog>


    <div class="checkItemsInner">

      <div class="checkItemsInnerHeader">
        <!-- 物品id搜索 -->
        <div class="inputDiv">
          <el-input
            v-model.number="searchByGoodsId"
            size="mini"
            placeholder="物品id搜索(回车)"
            @keyup.enter.native="searchByGoodsIdFunc"/>
        </div>
        <!-- 物品名搜索 -->
        <div class="inputDiv">
          <el-input
            v-model.trim="searchByGoodsName"
            size="mini"
            placeholder="物品名搜索(回车)"
            @keyup.enter.native="searchByGoodsNameFunc"/>
        </div>
        
        <!-- 查看全部按钮 -->
        <el-button class="seeAll" type="primary" round @click="seeAll">查看全部</el-button>
      </div>

      <!-- 展示页面 -->
      <el-table :data="tableData" border align="center" class="itemsTable" :header-cell-style="{'text-align':'center'}">
          <el-table-column width="100px" prop="goodsId" label="物品id" align='center'></el-table-column>
          <el-table-column prop="goodsImage" label="物品照片" align='center'>
              <template slot-scope="scope">
                  <img style="width:200px;max-height:200px;object-fit:contain;" :src="scope.row.goodsImage">
              </template>
          </el-table-column>
          <el-table-column width="100px" prop="goodsName" label="物品名称" align='center'></el-table-column>
          <!-- 状态 -->
          <el-table-column
            width="100px"
            align='center'
            prop="goodsState"
            label="物品状态"
            :filters="[{ text: '未损坏', value: '未损坏' }, { text: '已损坏', value: '已损坏' }]"
            :filter-method="filterTag"
            filter-placement="bottom-end">
            <template slot-scope="scope">
              <el-tag
                :type="scope.row.goodsState === '未损坏' ? 'info' : 'danger'"
                disable-transitions>{{scope.row.goodsState}}</el-tag>
            </template>
          </el-table-column>
          <!-- 操作 -->
          <el-table-column label="操作" align='center'>
              <template slot-scope="scope">
                  <el-button type="primary" @click="damageReportFromItems(scope.$index,scope.row)" size="mini">损坏上报</el-button>
                  <el-button type="success" @click="editClick(scope.$index,scope.row)" size="mini">编辑</el-button>
                  <el-button type="danger" @click="removeClick(scope.$index,scope.row)" size="mini">删除</el-button>
              </template>
          </el-table-column>
      </el-table>
    </div>

    
    <!-- 分页 -->
    <div class="pagination">
      <Pagination :total="total" :pageSize="pageSize" :totalPages="totalPages" @currentChange="currentChange"></Pagination>
    </div>

  </div>
</template>

<script>
// 防抖引入
import { debounce } from 'lodash-es';
import Pagination from '@/components/pagination/Pagination';
import { itemsList,searchByGoodsNameFunc,searchByGoodsIdFunc,itemsRemove,itemsAdd,itemsEdit } from '@/api/goods/goodsAdmin.js'
import { damageReported } from "@/api/damage/damageAdmin.js"

export default {
  name: 'Content-CheckItems',
  components:{Pagination,},
  data() {
    return {
      formLabelWidth: '120px',
      tableData: [],
      // 控制弹窗
      dialogFormVisibleAdd: false,
      dialogFormVisibleEdit: false,
      // 弹窗标题
      dialogFormVisibleTitle: "",
      // 添加物品
      items: {
        goodsId: '',
        goodsName: '',
        goodsQuantity:'',
        goodsState: '',
        goodsImage: '',
      },
      // 上报损坏物品信息
      report: {
        reportNameId:'',        // 1上报人id
        reportName:'',          // 1上报人账号：用户自己
        goodsId: '',            // 1上报物品id
        damageDescription: '',  // 1上报损坏描述
      },
      // 搜索
      searchByGoodsName: '',
      searchByGoodsId: '',
      // 控制上报
      dialogFormVisibleReported: false,
      // 暂存图片
      fileList:[],
      files:[],
      imageOK: false,
      // 添加物品规则
      rules: {
        goodsName: [
          { required: true, message: '请输入物品名称', trigger: 'blur' },
        ],
        goodsQuantity: [
          { required: true, message: '请输入物品数量', trigger: 'blur' },
        ],
        goodsState: [
          { required: true, message: '请选择物品状态', trigger: 'change' }
        ],
        goodsImage: [
          { required: true, message: '请上传图片', trigger: 'change'}, 
        ],
      },
      // 关于页码
      // 总共条数
      total: 0,
      // 页码数量
      totalPages: 10,
      // 当前页码有几个
      pageSize: 5,
      // 当前页码
      pageNum: 1,
    };
  },
  methods: {
    // 获取物品列表数据接口
    async getItemsList(pageNum,pageSize){
    let res = await itemsList({pageNum: pageNum,pageSize: pageSize})
      console.log("产品列表数据-----",res)
      if(res.data){
        // 列表赋值
        this.tableData = [...res.data.data.list]
        this.total = res.data.data.total
        this.totalPages = res.data.totalPages
        this.tableData.forEach( (e,index) => {
          e.goodsImage = 'data:image/png;base64,' + res.data.responseEntityList[index].body
        })
      } else{
        // 列表赋值
        this.tableData = []
        this.total = 0
        this.totalPages = 0
      }
    },

    // 添加新物品接口
    async postItemsAdd(formData){
      let res = await itemsAdd({formData: formData})
      console.log("增加产品列表-----",res);
      if(res.status === 201){
        this.$message({
          type: 'success',
          message: '添加成功咯!'
        })
        this.dialogFormVisibleAdd = false
        // 重新获取列表
        this.getItemsList(1,this.pageSize)
      }
      
    },

    // 上报提交接口
    async postDamageReported(report){
      let res = await damageReported({items: report})
      console.log("上报提交-----",res);
      if(res.status === 201){
        this.$message({
          type: 'success',
          message: '上报成功咯!',
        })
        this.dialogFormVisibleReported = false
        this.report.goodsId = ""
        this.report.damageDescription = ""
        // 重新获取列表
        this.getItemsList(1,this.pageSize)
      }
    },

    //修改接口
    async postItemsEdit(formData){
      let res = await itemsEdit({formData: formData})
      console.log("修改产品列表-----",res);
      if(res.status === 200){
        this.$message({
          type: 'success',
          message: '修改成功咯!'
        })
        this.dialogFormVisibleEdit = false
        // 重新获取列表
        this.getItemsList(this.pageNum,this.pageSize)
      }
    },

    // 删除接口
    async getItemsRemove(id){
      let res = await itemsRemove({goodsId: id})
      console.log("产品删除数据-----",res)
      if(res.status === 200){
        this.$message({
          type: 'success',
          message: '删除成功咯!'
        })
        // 重新获取列表
        this.getItemsList(1,this.pageSize)
      }
    },

    // 物品名字搜索接口
    async getSearchByGoodsNameFunc(pageNum,pageSize,goodsName){
      let res = await searchByGoodsNameFunc({pageNum: pageNum, pageSize: pageSize, goodsName: goodsName})
      console.log("物品名字搜索数据-----",res);
      if(res.data){
        // 列表赋值
        this.tableData = [...res.data.data.list]
        this.tableData.forEach( (e,index) => {
          e.goodsImage = 'data:image/png;base64,' + res.data.responseEntityList[index].body
        })
        this.total = res.data.data.total
        this.totalPages = res.data.totalPages
        this.pageNum = 1
      } else{
        // 列表赋值
        this.tableData = []
        this.total = 0
        this.totalPages = 0
      }
      
    },

    // 物品id搜索接口
    async getSearchByGoodsIdFunc(goodsId){
      let res = await searchByGoodsIdFunc({goodsId: goodsId})
      console.log("物品id搜索数据-----",res);
      if(res.data){
        // 列表赋值
        console.log("id赋值");
        this.tableData = [...res.data.data.list]
        this.tableData.forEach( (e,index) => {
          e.goodsImage = 'data:image/png;base64,' + res.data.responseEntityList[index].body
        })
        this.total = 1
        this.totalPages = 1
        this.pageNum = 1
      } else{
        // 列表赋值
        this.tableData = []
        this.total = 0
        this.totalPages = 0
      }
      
    },

    // 更新页码
    currentChange(val){
      console.log("更新页码-----",val);
      this.pageNum = val
      this.getItemsList(val,this.pageSize)
    },

    // 上报弹窗展开
    damageReportFromItems(index,row){
      console.log("上报弹窗展开",index,row);
      this.dialogFormVisibleReported = true
      this.report.goodsId = row.goodsId
    },
    // 上报提交操作
    submitFormReport(){
      this.$refs.report.validate((valid) => {
        if (valid) {
          console.log("上报提交按钮-----",this.report);
          this.postDamageReported(this.report)
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },

    // 修改
    editClick(index, row) {
      console.log("修改操作-----",index, row); 
      // 触发弹窗
      this.dialogFormVisibleEdit = true
      // 将弹窗标题修改
      this.dialogFormVisibleTitle = "修改物品数据"
      // 往表单填数据
      this.items.goodsId = row.goodsId
      this.items.goodsName = row.goodsName
      this.items.goodsState = row.goodsState
    },
    // 修改弹窗的提交按钮
    editClickButton(items) {
      this.$refs[items].validate((valid) => {
        if (valid) {
          console.log("修改操作的确认-----",this.items);
          this.submitFormEdit()
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
        this.getItemsRemove(row.goodsId)
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
      this.dialogFormVisibleAdd = true;
      // 将弹窗标题修改
      this.dialogFormVisibleTitle = '添加新物品'
      // 表单数据清空
      this.items.goodsName = ""
      this.items.goodsState = ""
      this.items.goodsQuantity = ""

    },
    // 提交新物品
    submitButton() {
      this.$refs.items.validate((valid) => {
        if (valid) {
          console.log("提交新物品操作-----",this.items);
          this.submitFormAdd()
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },

    // 获取图片对象
    changeFile(file, fileList) {
      //图片格式
      const isJPG = file.raw.type === 'image/jpg' || file.raw.type === 'image/png';
      //图片大小
      const isLt2M = file.raw.size / 1024 / 1024 < 1;
      if (!isJPG) {
        this.$message.error('上传图片只能为png格式');
        this.items.goodsImage = ""
      }else if (!isLt2M) {
        this.$message.error('上传图片大小不能超过1MB');
        this.items.goodsImage = ""
      }else{
        console.log("图片符合要求");
        this.items.goodsImage = URL.createObjectURL(file.raw);
        // 选择文件后，给fileList对象赋值
        this.imageOK = true
        console.log("fileList",fileList);
        this.fileList = fileList
      }
    },
    // 正式提交新物品
    submitFormAdd(){
      let formData = new window.FormData()
      this.items.goodsImage = this.fileList[0].raw
      formData.append("uploadImage",this.fileList[0].raw)
      formData.append("goodsName",this.items.goodsName)
      formData.append("goodsState",this.items.goodsState)
      formData.append("goodsQuantity",this.items.goodsQuantity)

      console.log("formData的uploadImage",formData.get("uploadImage"));
      // 发送请求
      this.postItemsAdd(formData)
    },

    // 修改物品
    submitFormEdit(){
      let formData = new window.FormData()
      if(this.imageOK){
        this.items.goodsImage = this.fileList[0].raw

        formData.append("uploadImage",this.fileList[0].raw)
        formData.append("goodsId",this.items.goodsId)
        formData.append("goodsName",this.items.goodsName)
        formData.append("goodsState",this.items.goodsState)

        console.log("formData的uploadImage",formData.get("uploadImage"));

        // 发送请求
        this.postItemsEdit(formData)
      }
      
    },

    // 物品名字搜索操作
    searchByGoodsNameFunc:debounce(function() {
      if(this.searchByGoodsName){
        console.log("我要搜索咯-----",this.searchByGoodsName);
        this.getSearchByGoodsNameFunc(this.pageNum,this.pageSize,this.searchByGoodsName)
      }
    }, 300),

    // 物品id搜索操作
    searchByGoodsIdFunc:debounce(function() {
      if(this.searchByGoodsId){
        console.log("我要搜索咯-----",this.searchByGoodsId);
        this.getSearchByGoodsIdFunc(this.searchByGoodsId)
      }
    }, 300),

    // 查看全部
    seeAll(){
      this.getItemsList(1,this.pageSize)
      this.searchByGoodsName = ''
      this.searchByGoodsId = ''
    },

    // 过滤标签 
    filterTag(value, row) {
      return row.goodsState === value;
    },
 
    
  },

  created() {
    this.getItemsList(1,this.pageSize)
  },
  mounted() {
    this.report.reportName = this.$store.state.login.name
    this.report.reportNameId = Number(this.$store.state.login.id)
  },
};
</script>

<style scoped>
  .checkItems{
    width: 100%;
    height: 100%;
    position: relative;
    
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
  .checkItemsInner{
    width: 80%;
    /* height: 100%; */
    font-size: 25px;
    margin: 40px auto;
    margin-bottom: 80px;
  }
  .checkItemsInnerHeader{
    display: flex;
    justify-content: space-between;
    align-items: center;
    
    margin-bottom: 10px;
  }
  .itemsButton{
    margin-top: 60px;
    font-size: 18px;
    position: fixed;
    border-radius: 20px;
    left: 20px;
    top: 5px;
    background-color: aliceblue;
    z-index: 1;
  }
  .inputDiv{
    margin-top: 60px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .inputDiv >>> .el-input{
    width: 150px;
    height: 40px;
  }
  .inputDiv >>> .el-input__inner{
    height: 100%;
    font-size: 10px;
  }
  .seeAll{
    margin-top: 60px;
  }
  .itemsImg{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  .itemsImg >>> .el-upload-list{
    width: 60%;
  }
  .itemsImg >>> .el-upload__tip{
    visibility:hidden;
  }
  .itemsTable{
    background-color: transparent;
    border-radius: 15px;
  }
  ::v-deep .el-table th,
  ::v-deep .el-table tr,
  ::v-deep .el-table td {
    background-color: rgba(255, 255, 255, 0.281) !important;
  }
  .dialog-footer{
    display: flex;
    justify-content: center;
    align-items: center;
  }
  /* 去除底部白线 */
  .el-table::before{
    background-color: transparent;
  }
</style>