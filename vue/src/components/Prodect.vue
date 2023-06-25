<script>
import {defineComponent} from 'vue'
import request from "../utils/request";
import Cookies from 'js-cookie'

const item = {
  product_id: '',
  name: '',
  price: '',
  quantity: '',
}

const header = {
  prop: "key",
  label: "自定义",
  editable: false,
  type: "input",
}

export default defineComponent({
  name: "Prodect",

  data() {
    return {
      search: "",
      user: Cookies.get('user') ? JSON.parse(Cookies.get('user')) : {},
      str :  "您确定删除苹果嘛？",
      tableHeader: [
        {
          prop: "product_id",
          label: "ID",
          editable: true,
          type: "input",
        },
        {
          prop: "name",
          label: "商品名",
          editable: true,
          type: "input"
        },
        {
          prop: "price",
          label: "价格",
          editable: true,
          type: "input"
        },
        {
          prop: "quantity",
          label: "数量",
          editable: true,
          type: "input"
        },
      ],
      // 请求
      tableData: [{
        product_id: '1',
        name: '冬枣',
        price: '30.0',
        quantity: '100',
      }],
      // 返回值
      fruitsList: [{}]
    }
  },
  created() {
    this.productInquire();
  },
  methods: {
    searchByName() {
      const url = '/tproduct/searchByName?name=' + this.search;
      request.post(url).then(res => {
        if (res.code === '200') {
          this.tableData = res.data;
          this.$notify.success("查询成功");
          this.search = "";
        } else {
          this.$notify.error("查询失败");
          this.search = "";
        }
      })
    },
    logout() {
      Cookies.remove('user');
      this.$router.push('/index')
      this.$notify.success("退出成功");
    },
    productInquire() {
      request.get('/tproduct/productInquire').then(res => {
        if (res.code === '200') {
          this.tableData = res.data;
          this.fruitsList = res.data;
        }
      })
    },
    handleEdit(row) {

      // row.editable = true;
      // console.log(row)
      let updateProduct = this.tableData[row];
      if (updateProduct.name === "") {
        this.$notify.error("商品名不能为空");
        this.productInquire();
        return
      }

      console.log(updateProduct.price)
      if (updateProduct.price >= 200 || updateProduct.price === '') {
        this.$notify.error("价格不能为空 且不能大于200元");
        this.productInquire();
        return;
      }

      if (updateProduct.quantity >= 1000 || updateProduct.quantity === '') {
        this.$notify.error("数量不能为空 且不能大于1000件");
        this.productInquire();
        return;
      }

      // let nameCheck = this.tableData[row].name;
      // this.productNameCheck(nameCheck, row);
      this.updateProduct(row);
    },
    // productNameCheck(name, row) {
    //
    //   const url = '/tproduct/productCheck/' + name;
    //   request.post(url).then(res => {
    //     if (res.code === '200') {
    //       this.updateProduct(row);
    //     } else {
    //       this.$notify.error("商品名重复 请重新修改");
    //       this.productInquire();
    //     }
    //   })
    // },
    updateProduct(index) {
      console.log(index);
      let updateProduct = this.tableData[index];

      request.put('/tproduct/productChange', updateProduct).then(res => {
        if (res.code === '200') {
          this.$notify.success("更新成功");
          this.productInquire();
        } else {
          this.$notify.error("更新失败");
          this.productInquire();
        }
      })
    },
    handleDelete(index) {
      console.log("删除操作", index + 1)

      let name = this.tableData[index].name;
      let deleteId = this.tableData[index].product_id;
      console.log(deleteId)
      const url = '/tproduct/productDeleteById/' + deleteId;
      request.delete(url).then(res => {
        if (res.code === '200') {
          this.$notify.success("删除成功");
          this.productInquire();
        } else {
          this.$notify.success("删除失败");
          this.productInquire();
        }
      })
    },
    deleteStr(index) {
      console.log(111)
      let name = this.tableData[index].name;
      this.str = "你确定删除" + name + "的数据吗？"
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
          <router-link to="/index">欢迎：{{ user.name }}</router-link>
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

    <!--      搜索框-->
    <div class="search_div">
      <el-form-item class="search_input" label="搜索:" prop="search">
        <el-input v-model="search" size="medium" type="text" prefix-icon="el-icon-search"
                  placeholder="请输入商品名">
        </el-input>
      </el-form-item>
      <el-button class="search_button" @click="searchByName()" type="primary">查询</el-button>
      <el-button class="search_button" @click="productInquire()" type="danger">重置</el-button>
    </div>


    <div style="padding-top: 50px">


      <!--      表头-->
      <el-table :data="tableData" style="width: 120vh; background-color: white">
        <el-table-column
            :prop="item.prop"
            :label="item.label"
            v-for="(item, index) in tableHeader"
            :key="item.prop"
        >
          <template #default="scope">
            <div v-show="item.editable || scope.row.editable"
                 class="editable-row">
              <template v-if="item.type === 'input'">
                <el-input
                    size="small"
                    v-model="scope.row[item.prop]"/>
              </template>
            </div>
          </template>

        </el-table-column>

        <el-table-column label="操作">
          <template #default="scope">
            <el-button
                size="small"
                @click="handleEdit(scope.$index)"
            >更新
            </el-button>

            <el-popconfirm :title= this.str
                           confirm-button-text="确定"
                           cancel-button-text="取消"
                           @confirm="handleDelete(scope.$index)"
                           @click="deleteStr(scope.$index)">
              <template #reference>
                <el-button
                    size="small"
                    type="danger"
                >删除
                </el-button>
              </template>
            </el-popconfirm>

          </template>

        </el-table-column>
      </el-table>
    </div>
  </div>

  <!-- 底部脚标 -->
  <div class="bottom_column">
    <h2>焦梓豪</h2>
  </div>
</template>


<style src="../style/product.css" scoped>

</style>