<!-- <script>
//写数据，不能再像之前写createapp函数了
export default{
  data(){
    return {
      msg:'上海'
    }
  }
}
</script> -->
<script setup>
  import{ref} from 'vue'
  //调用ref函数，定义响应式数据（页面发生变化，数据发生变化）
  const msg = ref('南京');
  //导入Api.vue文件
  import APIVue from './Api.vue'

  //导入Article.vue文件
  import ArticleVue from './Article.vue'
</script>
<template>
  <!--HTML展示代码-->
  <!-- <h1>北京</h1> -->
  <!-- <h1>{{msg}}</h1>
  <br>
  <APIVue/> -->
  <ArticleVue/>
</template>

<style scoped>
  /*样式 */
  h1{
    color:red;
  }
</style>
