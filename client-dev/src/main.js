// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'
import VeeValidate from 'vee-validate'
import VueResource from 'vue-resource'
import App from './App'
import store from './store'
import router from './router'
import { sync } from 'vuex-router-sync'
import { getCookie, signOut, isLogin } from '@/services/auth'
import CustomPlugin from 'src/components/custom-components-plugins'


Vue.config.productionTip = false
Vue.use(CustomPlugin)
Vue.use(BootstrapVue)
Vue.use(VueResource)

// HTTP related
Vue.http.options.crossOrigin = true
Vue.http.options.credentials = true

Vue.http.interceptors.push((request, next) => {
  // The request body is processed here
  request.headers = request.headers || {}
  if (isLogin()) {
    request.headers.set('Authorization', 'Bearer ' + getCookie('token').replace(/(^")|("$)/g, ''))
  }
  next((response) => {
    // Here you can process the response
    if (response.status === 401) {
      signOut()
      window.location.pathname = '/login'
    }
  })
})

// NOTE: workaround for VeeValidate + vuetable-2
Vue.use(VeeValidate, {fieldsBagName: 'formFields'})

sync(store, router)

let mediaHandler = () => {
  if (window.matchMedia(store.getters.config.windowMatchSizeLg).matches) {
    store.dispatch('toggleSidebar', true)
  } else {
    store.dispatch('toggleSidebar', false)
  }
}

router.beforeEach((to, from, next) => {
  store.commit('setLoading', true)
  if (to.matched.some(record => record.meta.goTop)) {
    window.scroll(0, 0)
  }

  if (to.matched.some(record => record.meta.requiresAuth)) {
    if (!isLogin()) {
      return next({ path: '/login' })
    }
  }
  if (to.matched.some(record => record.meta.requiresNotAuth)) {
    if (isLogin()) {
      return next({ path: '/' })
    }
  }
  next()
})

router.afterEach((to, from) => {
  mediaHandler()
  store.commit('setLoading', false)
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
