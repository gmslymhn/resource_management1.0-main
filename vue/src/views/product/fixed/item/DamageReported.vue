<template>
  <div class="damageReported">
    
    <div class="itemsText">
      <p class="itemsTextP">物品损坏上报</p>
    </div>

    <!-- 上报页面 -->
    <div class="damageReportedInner">
      <el-form :model="items" :rules="rules" ref="items" class="demo-ruleForm">
        <el-form-item label="物品id(请输入数字)" prop="goodsId">
          <el-input v-model.number="items.goodsId"></el-input>
        </el-form-item>
        <el-form-item label="物品名称" prop="goodsName">
          <el-input v-model="items.goodsName"></el-input>
        </el-form-item>
        <el-form-item label="损坏描述" prop="goodsProblem">
          <el-input type="textarea" v-model="items.goodsProblem"></el-input>
        </el-form-item>
      </el-form>

      <div slot="footer" class="damageReportedButton">
        <el-button type="primary" @click="submitForm()">上 报</el-button>
        <el-button type="success" round class="reportedList" @click="reportedList()">上报列表</el-button>
      </div>
    </div>


    <!-- 上报列表弹窗 -->
    <el-dialog title="上报列表" :visible.sync="dialogFormVisible" :append-to-body="true" class="itemsDialog">
      
      <template>
        <el-button @click="clearFilter">重置过滤器</el-button>
        <el-table
          ref="filterTable"
          :data="tableData"
          style="width: 100%">
          <el-table-column
            prop="date"
            label="日期"
            sortable
            width="180"
            column-key="date"
          >
          </el-table-column>
          <el-table-column
            prop="people"
            label="上报人"
            width="180">
          </el-table-column>
          <el-table-column
            prop="id"
            label="物品id"
            >
          </el-table-column>
          <el-table-column
            prop="name"
            label="物品名称"
            :formatter="formatter">
          </el-table-column>
          <el-table-column
            prop="tag"
            label="标签"
            width="100"
            :filters="[{ text: '未处理', value: '未处理' }, { text: '未同意', value: '未同意' }, { text: '已同理未处理', value: '已同理未处理' }, { text: '已处理', value: '已处理' }]"
            :filter-method="filterTag"
            filter-placement="bottom-end">
            <template slot-scope="scope">
              <el-tag
                :type="tagColor(scope)"
                disable-transitions>{{scope.row.tag}}</el-tag>
            </template>
          </el-table-column>
        </el-table>
      </template>
        
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">关 闭</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import dayjs from "dayjs"
import { damageReported } from "@/api/damage/damage.js"
export default {
  name: 'Content-DamageReported',

  data() {
    return {
      // 列表
      tableData: [{
        date: '2023-07-02 03:29:33',
        people: '王小虎',
        name: '物品名字',
        id: 1,
        tag: '未处理'
      }, {
        date: '2023-07-04 03:29:33',
        people: '王小虎',
        name: '物品名字',
        id: 1,
        tag: '未同意'
      }, {
        date: '2023-07-01 03:29:33',
        people: '王小虎',
        name: '物品名字',
        id: 1,
        tag: '已同理未处理'
      }, {
        date: '2023-07-03 03:29:33',
        people: '王小虎',
        name: '物品名字',
        id: 1,
        tag: '已处理'
      }],
      // 损坏物品信息
      items: {
        goodsPeople:'',     // 上报人：用户自己
        goodsId: '',        // 上报物品id
        goodsName: '',      // 上报物品名称
        goodsProblem: '',   // 上报损坏描述
        goodsTime: '',      // 上报时间

        // 上报列表
        goodsTag: '',     // 处理状态
      },
      // 控制弹窗
      dialogFormVisible: false,
      // 添加物品规则
      rules: {
        goodsId: [
          { required: true, message: '请输入物品id', trigger: 'blur' },
        ],
        goodsName: [
          { required: true, message: '请输入物品名称', trigger: 'blur' },
        ],
        goodsProblem: [
          { required: true, message: '请输入损坏描述', trigger: 'blur' }
        ],
      },
    };
  },
  methods: {
    // 上报提交接口
    async postDamageReported(items){
      let res = await damageReported({items})
      console.log("上报提交-----",res.data);
    },
    // 上报提交
    submitForm(items) {
      this.$refs.items.validate((valid) => {
        if (valid) {
          console.log("validate-----",this.$refs.items);
          this.goodsTime = dayjs(Date.now()).format("YYYY-MM-DD HH:mm:ss");
          this.postDamageReported(this.items)
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    // 上报列表弹窗展开
    reportedList(){
      this.dialogFormVisible = true
    },
    // 上报列表函数
    formatter(row, column) {
      return row.name;
    },
    filterTag(value, row) {
      return row.tag === value;
    },
    clearFilter() {
      this.$refs.filterTable.clearFilter();
    },
    // 状态颜色判断
    tagColor(scope){
      if(scope.row.tag === "未处理"){
        return "info"
      } else if(scope.row.tag === "未同意"){
        return "danger"
      } else if(scope.row.tag === "已同理未处理"){
        return "warning"
      } else if(scope.row.tag === "已处理"){
        return "success"
      } 
    },


  }
};
</script>

<style scoped>
  .damageReported{
    width: 100%;
    height: 100%;
    position: relative;
    background-color: rgba(255, 255, 255, 0.6);
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
  .damageReportedInner{
    width: 60%;
    height: 100%;
    font-size: 25px;
    margin: 60px auto;
  }
  .reportedList{
    position: fixed;
    right: 20%;
  }
  .dialog-footer{
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>