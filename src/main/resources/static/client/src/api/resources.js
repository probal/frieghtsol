import Vue from 'vue'
import VueResource from 'vue-resource'
import { API_ROOT } from '../config'
import { getCookie, signOut, isLogin } from '../utils/authService'

Vue.use(VueResource)

// HTTP related
Vue.http.options.crossOrigin = true
Vue.http.options.credentials = true

Vue.http.interceptors.push((request, next) => {
    // The request body is processed here
    request.headers = request.headers || {}
    if (isLogin()) {
        request.headers.set('Authorization', 'Bearer ' + getCookie('token').replace(/(^\")|(\"$)/g, ''))
    }
    next((response) => {
        // Here you can process the response
        if (response.status === 401) {
            signOut()
            window.location.pathname = '/login'
        }
    })
})

export const UserResource = Vue.resource(API_ROOT + 'users{/id}')
export const AuthResource = Vue.resource(API_ROOT + 'auth{/id}')