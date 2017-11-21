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

export function Http (resource) {
  return new Promise((resolve, reject) => {
    resource.then(response => {
      console.log(response)
      if (!response.ok) {
        reject(response.data)
        return // showMsg(store, response.data.error_msg || 'Login failed')
      }
      resolve(response.data)
    }, response => {
      console.log(response)
      reject(response.data)
      // showMsg(store, response.data.error_msg || 'Login failed')
    })
  })
}

export const AuthResource = Vue.resource(`${API_ROOT}{state}/auth{/id}`)
