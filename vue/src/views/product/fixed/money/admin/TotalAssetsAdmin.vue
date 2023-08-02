<template>
  <div class="damageReported">
    <div class="itemsText">
      <p class="itemsTextP">资产</p>
    </div>
    <el-form ref="form" :model="form" label-width="80px">
  <el-form-item label="活动名称">
    <el-input v-model="form.name"></el-input>
  </el-form-item>
  <el-form-item label="资产区域">
    <el-select v-model="form.region" placeholder="请选择活动区域">
      <el-option label="SelabA1" value="shanghai"></el-option>
      <el-option label="SelabA2" value="beijing"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="购入时间">
    <el-col :span="11">
      <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
    </el-col>
    <el-col class="line" :span="2">-</el-col>
    <el-col :span="11">
      <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
    </el-col>
  </el-form-item>
  <el-form-item label="是否公用">
    <el-switch v-model="form.delivery"></el-switch>
  </el-form-item>
  <el-form-item label="资产类型">
    <el-checkbox-group v-model="form.type">
      <el-checkbox label="办公" name="type"></el-checkbox>
      <el-checkbox label="卫生" name="type"></el-checkbox>
      <el-checkbox label="消耗品" name="type"></el-checkbox>
      <el-checkbox label="其他" name="type"></el-checkbox>
    </el-checkbox-group>
  </el-form-item>
  <el-form-item label="特殊资源">
    <el-radio-group v-model="form.resource">
      <el-radio label="空调"></el-radio>
      <el-radio label="空调"></el-radio>
    </el-radio-group>
  </el-form-item>
  <el-form-item label="资产描述">
    <el-input type="textarea" v-model="form.desc"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">立即提交</el-button>
    <el-button>取消</el-button>
  </el-form-item>
</el-form>
  </div>
</template>

<script>
//引入三个关于资金管理的接口
import { changePercentage,getAllAssets,getAllNewAssets } from '@/api/admassets/admassetsAdmin.js'
export default {
    data() {
      return {
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      }
    }
  }
</script>

<style scoped>
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
  .damageReported{
    width: 100%;
    height: 100%;
    position: relative;
    background-color: rgba(255, 255, 255, 0.6);
  }
</style>