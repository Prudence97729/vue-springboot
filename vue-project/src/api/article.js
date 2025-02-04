// //导入axios
// import axios from 'axios'
// //定义一个变量，记录公共的前缀
// const baseURL = 'http://localhost:8080';
// const instance = axios.create({baseURL});
import request from '@/util/request.js';

//获取所有文章数据的函数
export function articleGetAllService(){
    //发送异步请求，获取所有文章数据
    //需要注意，这里的异步请求不会把数据返回给函数外部
    //需要同步等待服务器响应的结果，并返回，async await
    return request.get('/article/getAll');
}


//根据文章分类和发布状态搜索的函数
export function articleSearchService(conditions){
    //发送请求，完成搜索
    return request.get('/article/search',{params:conditions});
}