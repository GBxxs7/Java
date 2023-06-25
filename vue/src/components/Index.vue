<script>
import {defineComponent} from 'vue'
import {ElConfigProvider} from 'element-plus'
import request from "../utils/request";
import Cookies from 'js-cookie'

export default defineComponent({
  components: {
    ElConfigProvider,
  },
  name: "AddProduct",
  data() {
    return {
      params: {
        name: "jzh",
        password: "123456"
      },
    }
  },
  methods: {}
})
</script>

<template>
  <!-- 头部栏 -->
  <div class="top_column">
    <h2>《云计算应用开发》 课程设计</h2>
  </div>

  <!-- 中部主体 -->
  <div class="mid_column">
    <ul>
      <li>
        <router-link to="/login">登陆</router-link>
      </li>
      <li>
        <router-link to="/product">浏览商品</router-link>
      </li>
      <li>
        <router-link to="/addProduct">添加商品</router-link>
      </li>
      <li>技术要求:</li>
    </ul>

    <ol>
      <li>Spring Boot 应用框架</li>
      <li>MyBatis 数据持久层框架</li>
      <li>Thymeleaf 模板引擎（数据渲染）</li>
      <li>身份验证 (Session与Cookie状态管理或JWT， Spring拦截器）</li>
      <li>数据检验机制 (Jakarta, Hibernate数据检验）</li>
      <li>异常处理机制</li>
      <li>Ajax异步请求 (jQuery或axios)</li>
      <li>密码加、解密（md5或sha256)</li>
      <li>防SQL注入攻击</li>
    </ol>
  </div>

  <!-- 底部脚标 -->
  <div class="bottom_column">
    <h2>焦梓豪</h2>
  </div>
</template>

<style src="../style/index.css" scoped>

</style>