// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import elementui from 'element-ui'
import axios from 'axios'
import 'element-ui/lib/theme-chalk/index.css'
import moment from 'moment'
Vue.config.productionTip = false

Vue.use(elementui)
Vue.use(require('vue-moment'))
Vue.prototype.moment=moment
Vue.prototype.$axios=axios

Vue.filter('dateFormat',function (datestr,patten='YYYY-MM-DD HH:mm:ss') {
  return moment(datestr).format(patten)
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
