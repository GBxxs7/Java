<script>
import {defineComponent} from 'vue'
import request from "../utils/request";
import Cookies from 'js-cookie'

export default defineComponent({
  name: "AddProduct",
  data() {
    return {
      user: Cookies.get('user') ? JSON.parse(Cookies.get('user')) : {},
      product: {

      },
      rules: {
        name: [{
          required: true,
          message: "请输入品名",
          trigger: "blur"
        },],
        price: [{
          required: true,
          message: "请输入价格",
          trigger: "blur"
        }, {
          type: 'number',
          min: 0,
          max: 200,
          message: "商品价格不得超过200元",
          trigger: 'blur'
        }],
        quantity: [{
          required: true,
          message: "请输入商品数量",
          trigger: "blur"
        }, {
          type: 'number',
          min: 0,
          max: 1000,
          message: "商品数量不得超过1000件",
          trigger: 'blur'
        }],
        descriptions: [{
          required: true,
          message: "请输入描述",
          trigger: "blur"
        },],
      },
    }
  },
  methods: {
    logout() {
      Cookies.remove('user')
      this.$router.push('/index')
      this.$notify.success("退出成功");
    },
    nameCheck() {
      const url = '/tproduct/productCheck/' + this.product.name;
      request.post(url).then(res => {
        if (res.code === '200') {
          this.addProduct();
        } else {
          this.$notify.error("商品名重复 请重新修改");
        }
      })
    },
    addProduct() {
      this.$refs["addProductForm"].validate((valid) => {
        if (valid) {
          request.post('/tproduct/productAdd', this.product).then(res => {
            if (res.code === '200') {
              this.$notify.success("添加成功")
              this.$router.push('/product')
            } else {
              this.$notify.error("添加失败")
            }
          })
        }
      })
    }
  }
})
</script>

<template>
  <!-- 头部栏 -->
  <div class="top_column">
    <table class="top_table">
      <tr>
        <td>
          <router-link to="/index">首页</router-link>
        </td>
        <td>
          <router-link to="/product">浏览商品</router-link>
        </td>
        <td>
          <router-link to="/AddProduct">添加商品</router-link>
        </td>
      </tr>
    </table>

    <table class="top_table">

      <tr>
        <td><h2>《云计算应用开发》 课程设计</h2></td>
      </tr>
    </table>

    <table class="top_table">
      <tr>
        <td>
          <router-link to="/addProduct">欢迎：{{ user.name }}</router-link>
        </td>
        <td>
          <router-link to="/index" @click="logout()">退出</router-link>
        </td>
      </tr>
    </table>
  </div>

  <!-- 中部主体 -->
  <div class="mid_column">
    <ul></ul>
    <el-form class="addProduct_form" :model="product" ref="addProductForm" :rules="rules">
      <el-form-item class="form_item" label="品名:" prop="name">
        <el-input v-model="product.name" size="medium" prefix-icon="el-icon-user" placeholder="请输入品名"></el-input>
      </el-form-item>
      <el-form-item class="form_item" label="价格:" prop="price">
        <el-input type="number"  v-model.number="product.price" size="medium" prefix-icon="el-icon-user" placeholder="请输入价格"></el-input>
      </el-form-item>
      <el-form-item type="number"  class="form_item" label="数量:" prop="quantity">
        <el-input v-model.number="product.quantity" size="medium" prefix-icon="el-icon-user"
                  placeholder="请输入数量"></el-input>
      </el-form-item>
      <el-form-item class="form_item" label="描述:" prop="descriptions">
        <el-input v-model="product.descriptions" size="medium" prefix-icon="el-icon-user"
                  placeholder="请输入描述"></el-input>
      </el-form-item>

      <el-form-item class="form_item">
        <el-button @click="nameCheck()" style="width: 50vh;" type="primary">添加</el-button>
      </el-form-item>
    </el-form>
  </div>

  <!-- 底部脚标 -->
  <div class="bottom_column">
    <h2>焦梓豪</h2>
  </div>

</template>

<style src="../style/addProduct.css" scoped>

</style>