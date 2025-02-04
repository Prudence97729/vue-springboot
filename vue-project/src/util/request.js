//定制请求的实例
//导入axios
import axios from 'axios';
//定义一个变量，记录公共前缀，baseURL
const baseURL = 'http://localhost:8080';
const instance = axios.create({baseURL});

//添加响应拦截器
instance.interceptors.response.use(
    result=>{
        return result.data;
    },
    err=>{
        alert('服务异常');
        return Promise.reject(err);//会把异步的状态转换成失败的状态
    }
)

export default instance;