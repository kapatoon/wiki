import {createRouter,createWebHashHistory} from 'vue-router'
import Home from '../views/home.vue'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    }
]

const router = createRouter(
    {
        history: createWebHashHistory(),
        routes: routes,
    }
)

export default router