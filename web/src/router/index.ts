import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'
import Doc from '../views/Doc.vue'
import AdminEbooks from '../views/admin/AdminEbooks.vue'
import AdminCategory from '../views/admin/AdminCategorys.vue'
import AdminDoc from '../views/admin/AdminDocs.vue'


const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/doc',
    name: 'Doc',
    component: Doc
  },
  {
    path: '/admin/ebooks',
    name: 'AdminEbooks',
    component: AdminEbooks
  },
  {
    path: '/admin/categorys',
    name: 'AdminCategory',
    component: AdminCategory
  },
  {
    path: '/admin/docs',
    name: 'AdminDoc',
    component: AdminDoc
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
