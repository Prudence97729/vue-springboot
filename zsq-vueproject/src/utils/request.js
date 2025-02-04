//定制请求的实例

//导入axios  npm install axios
import axios from 'axios';
import { ElMessage } from 'element-plus'
//定义一个变量,记录公共的前缀  ,  baseURL
//配置代理
//const baseURL = 'http://localhost:8080';
const baseURL = '/api';
const instance = axios.create({
    baseURL,
    timeout: 10000
});

import {useTokenStore} from '@/stores/token.js'

//添加请求拦截器
instance.interceptors.request.use(
    (config)=>{
        //请求前的回调
        //添加token
        const tokenStore = useTokenStore();
        //判断有没有token
        if(tokenStore.token){
            config.headers.Authorization = tokenStore.token
        }
        return config;
    },
    (error)=>{
        //请求错误的回调
        return Promise.reject(error)
    }
)
// import { useRouter } from 'vue-router';
// const router = useRouter();
import router from '@/router'
//添加响应拦截器
instance.interceptors.response.use(
    (response)=>{
        //判断业务状态码
        if(response.data.code===0){
            return response.data;
        }
        //操作失败
        ElMessage.error(response.data.msg?response.data.msg:'服务异常')
        return Promise.reject(response.data);
    },
    (error)=>{
        //判断响应状态码，如果为401，表示未登录，需要跳转到登录页面
        if(error.response?.status===401){
            ElMessage.error('请先登录')
            router.push('/login')
        }else{
            ElMessage.error('服务异常')
        }
        return Promise.reject(error);
    }
)

export default instance;