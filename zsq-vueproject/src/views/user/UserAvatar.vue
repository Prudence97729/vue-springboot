<script setup>
import { Plus, Upload } from '@element-plus/icons-vue'
import { ref, onUnmounted } from 'vue'
import avatar from '@/assets/default.png'
import { ElMessage } from 'element-plus'
import { userUpdateAvatarService } from '@/api/user'
import { useTokenStore } from '@/stores/token.js'
import useUserInfoStore from '@/stores/userInfo.js'

const tokenStore = useTokenStore()
const uploadRef = ref()
const selectedFile = ref(null)

const userInfoStore = useUserInfoStore()
const imgUrl = ref(userInfoStore.info.userPic || avatar)

// 处理文件选择改变
const handleChange = (uploadFile) => {
  // 验证文件类型
  if (!uploadFile.raw.type.startsWith('image/')) {
    ElMessage.warning('请选择图片文件')
    return
  }
  
  // 验证文件大小（例如限制为 5MB）
  const maxSize = 5 * 1024 * 1024
  if (uploadFile.raw.size > maxSize) {
    ElMessage.warning('图片大小不能超过 5MB')
    return
  }

  selectedFile.value = uploadFile.raw
  
  // 修改预览逻辑
  if (uploadFile.raw) {
    imgUrl.value = URL.createObjectURL(uploadFile.raw)
  }
}

// 添加图片加载处理
const handleImageLoad = (e) => {
  console.log('图片加载成功:', e.target.src)
}

const handleImageError = (e) => {
  console.error('图片加载失败:', e.target.src)
  ElMessage.error('图片加载失败')
}

// 处理头像上传
const handleAvatarUpload = async () => {
  if (!selectedFile.value) {
    ElMessage.warning('请先选择图片')
    return
  }

  const formData = new FormData()
  formData.append('avatar', selectedFile.value)

  try {
    const res = await userUpdateAvatarService(formData)
    console.log('上传响应:', res)
    
    // 直接使用后端返回的完整路径
    const avatarUrl = `${import.meta.env.VITE_API_URL}${res.data}`
    console.log('图片URL:', avatarUrl)
    
    // 更新状态
    imgUrl.value = avatarUrl
    userInfoStore.setInfo({
      ...userInfoStore.info,
      userPic: avatarUrl
    })
    ElMessage.success('头像更新成功')
  } catch (error) {
    console.error('上传失败详情:', error)
    ElMessage.error(error.message || '上传失败，请重试')
  }
}

// 组件卸载时清理
onUnmounted(() => {
  if (imgUrl.value && imgUrl.value.startsWith('blob:')) {
    URL.revokeObjectURL(imgUrl.value)
  }
})
</script>

<template>
  <el-card class="page-container">
    <template #header>
      <div class="header">
        <span>更换头像</span>
      </div>
    </template>
    <el-row>
      <el-col :span="12">
        <el-upload 
          ref="uploadRef"
          class="avatar-uploader" 
          :show-file-list="false"
          :auto-upload="false"
          accept=".jpg,.jpeg,.png"
          :on-change="handleChange"
        >
          <img
            v-if="imgUrl"
            :src="imgUrl"
            class="avatar"
            @load="handleImageLoad"
            @error="handleImageError"
            crossorigin="anonymous"
          />
          <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
        </el-upload>
        <br />
        <el-button type="primary" :icon="Plus" size="large" @click="uploadRef.$el.querySelector('input').click()">
          选择图片
        </el-button>
        <el-button 
          type="success" 
          :icon="Upload" 
          size="large" 
          @click="handleAvatarUpload"
          :disabled="!selectedFile"
        >
          上传头像
        </el-button>
      </el-col>
    </el-row>
  </el-card>
</template>

<style scoped>
.avatar-uploader {
  :deep(.el-upload) {
    border: 1px dashed var(--el-border-color);
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
}

.avatar {
  width: 278px;
  height: 278px;
  display: block;
  object-fit: cover;
  border-radius: 6px;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 278px;
  height: 278px;
  text-align: center;
  line-height: 278px;
}

/* 添加图片加载过渡效果 */
img {
  transition: all 0.3s ease;
  &.loading {
    opacity: 0.5;
  }
}
</style>