import Vue from 'vue'
import Router from 'vue-router'
import login from '@/Views/login/login'
import home from '@/Views/home/home'
import bill from '@/Views/bill/bill'
import billupdate from '@/Views/bill/billUpdate'
import users from '@/Views/user/users'
import addusers from '@/Views/user/addUser'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/home',
      name: 'home',
      component: home,
      children:[
        {
          path: '/home/bill',
          name: 'bill',
          component: bill
        },
        {
          path: '/home/update',
          name: 'update',
          component: billupdate
        },
        {
          path: '/home/users',
          name: 'users',
          component: users
        },
        {
          path: '/home/addusers',
          name: 'addusers',
          component: addusers
        }
      ]
    },
    {
      path: '/bill',
      name: 'bill',
      component: bill
    },
    {
      path: '/update',
      name: 'update',
      component: billupdate
    },
    {
      path: '/users',
      name: 'users',
      component: users
    },
    {
      path: '/addusers',
      name: 'addusers',
      component: addusers
    }
  ]
})
