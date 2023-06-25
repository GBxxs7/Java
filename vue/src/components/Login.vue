<script>
import {defineComponent} from 'vue'
import request from "../utils/request";
import Cookies from 'js-cookie'


export default defineComponent({
  name: "Login",
  data() {
    return {
      loginUser: {},
      user: {},
      rules: {
        name: [{
          required: true,
          message: "请输入用户名",
          trigger: "blur"
        },],
        password: [{
          required: true,
          message: "请输入密码",
          trigger: "blur"
        },],
      },
    }
  },
  created() {
    const userJson = Cookies.get('user')
    if (userJson === null) {
      this.$router.push("/login");
    } else {
      this.$router.push("/product");
    }

  },
  methods: {
    login() {
      this.$refs["loginForm"].validate((valid) => {
        if (valid) {
          request.post('/tuser/userLogin', this.user).then(res => {
            if (res.code === '200') {
              this.loginUser = res.data;
              Cookies.set('user', JSON.stringify(this.loginUser))
              this.$notify.success("登录成功")
              this.$router.push('/product')
            } else {
              this.$notify.error(res.data)
            }
          })
        }
      })
    },
  }
})
</script>

<template>

  <!-- 头部栏 -->
  <div class="top_column">
    <h2>《云计算应用开发》 课程设计</h2>
  </div>

  <!-- 中部主体 -->
  <div class="mid_column">
    <ul></ul>
    <el-form :model="user" class="login_form" ref="loginForm" :rules="rules" hide-required-asterisk=true>
      <el-form-item class="form_item" label="账号:" prop="name">
        <el-input v-model="user.name" size="medium" prefix-icon="el-icon-user" placeholder="请输入账号"></el-input>
      </el-form-item>
      <el-form-item class="form_item" label="密码:" prop="password">
        <el-input v-model="user.password" size="medium" type="password" prefix-icon="el-icon-lock"
                  placeholder="请输入密码" show-password>
        </el-input>
      </el-form-item>
      <el-form-item class="form_item">
        <el-button @click="login()" style="width: 50vh;" type="primary">登录</el-button>
      </el-form-item>
    </el-form>

  </div>

  <!-- 底部脚标 -->
  <div class="bottom_column">
    <h2>焦梓豪</h2>
  </div>
</template>

<style scoped src="../style/login.css">

</style>