<script setup>
    import {ref,onMounted} from 'vue'
    //声明响应式数据ref
    const count = ref(0);
    //const count = 0;//注意这种写法不对，
    //在组合式api中一般需要把数据定义为响应式数据
    
    //声明函数
    function increase() {
        count.value++;
    }

    //声明钩子函数onMounted
    onMounted(() => {
        console.log('vue已经挂载完毕...')
    });

</script>

<template>
    <!--写html元素-->
    <button @click="increase">count:{{count}}</button>
</template>