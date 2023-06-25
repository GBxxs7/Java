import './assets/globle.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from "./router" //匹配自己项目所对应的路径
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const app = createApp(App)

app.use(ElementPlus)
app.use(ElementPlus, { size: 'small', zIndex: 3000 })
app.use(router).mount("#app") //使用配置的路由
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}