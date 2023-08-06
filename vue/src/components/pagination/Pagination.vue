<template>
  <div class="pagination">
    <el-pagination
      @current-change="currentChange"
      :current-page="currentPage"
      :page-size="pageSize"
      :page-count="totalPages"
      layout="total, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: 'CheckItems-Pagination',
  props:{
    total:{
      type:Number,
      defalut:100
    },
    pageSize:{
      type:Number,
      defalut:5
    },
    totalPages:{
      type:Number,
      defalut:10
    }

  },
  data() {
    return {
      currentPage: 1,
    };
  },
  methods: {
    currentChange(val) {
      console.log(`当前页: ${val}`);
      this.$emit("currentChange",val)
    }
  },
    
};
</script>

<style scoped>
  .pagination{
    height: 50px;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;

    background-color: rgba(255, 255, 255, 0.815) !important;
    width: 100%;
    position: fixed;
    bottom: 0;
  }
</style>