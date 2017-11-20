import Vue from 'vue'
import VueResource from 'vue-resource'
import { API_ROOT } from '@/config.js'
import { getToken, signOut, isLogin } from '@/services/auth'

Vue.use(VueResource)

// HTTP related
Vue.http.options.crossOrigin = true
Vue.http.options.credentials = true

Vue.http.interceptors.push((request, next) => {
  // The request body is processed here
  request.headers = request.headers || {}
  if (isLogin()) {
    request.headers.set('Authorization', 'Bearer ' + getToken().replace(/(^")|("$)/g, ''))
  }
  next((response) => {
    // Here you can process the response
    if (response.status === 401) {
      signOut()
      window.location.pathname = '/login'
    }
  })
})

export const AuthResource = Vue.resource(`${API_ROOT}public/auth{/id}`)
