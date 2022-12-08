import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'
import AdminEbooks from '../views/admin/AdminEbooks.vue'
import AdminCategory from '../views/admin/AdminCategorys.vue'


const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home
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
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
