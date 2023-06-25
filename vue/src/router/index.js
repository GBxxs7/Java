import {createRouter, createWebHashHistory, createWebHistory} from "vue-router"
import Cookies from "js-cookie";


//1. 定义要使用到的路由组件  （一定要使用文件的全名，得包含文件后缀名）
import index from "../components/Index.vue"
import login from "../components/Login.vue"
import product from "../components/Prodect.vue"
import addProduct from "../components/AddProduct.vue"

//2. 路由配置
const routes = [
    //redirect 重定向也是通过 routes 配置来完成，下面就是从 / 重定向到 /index
    {
        path: "/",
        redirect: "/index",
    },
    {path: "/index", component: index},
    {path: "/login", component: login},
    {path: "/product", component: product},
    {path: "/addProduct", component: addProduct},
    {
        path: '/404',
        name: '404',
        component: () => import('../components/404.vue')
    },
    {
        path: '/:pathMatch(.*)',
        redirect: '/404'
    },
]

// 3. 创建路由实例
const router = createRouter({
    // （1）采用hash 模式
    history: createWebHashHistory(),
    // （2）采用 history 模式
    // history: createWebHistory(),
    routes, //使用上方定义的路由配置
})


router.beforeEach((to, from, next) => {
    if (to.path === "/login") next();
    const user = Cookies.get("user");

    //  强制退回登陆页面

    if (!user && to.path !== "/login" && to.path !== "/index") {
        next("/login");
        setTimeout("console.clear()", 300);
        return;
    }
    // 当访问 /index 时 并且 cookie 存在 user 数据 则放行
    next();
});


// 4. 导出router
export default router