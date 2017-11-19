import Vue from 'vue'

import {
  LOGOUT_USER,
  LOGIN_SUCCESS
} from './mutation-types'

// import router from '../../router'
import { signOut } from '@/services/auth'
import { API_ROOT } from '@/config.js'

export function logout ({ commit }) {
  signOut()
  commit(LOGOUT_USER)
  window.location.pathname = '/'
}

export function localLogin (store, userInfo) {
  const api = `${API_ROOT}api/v1/public/login/doLogin`
  Vue.http.post(api, userInfo).then(response => {
    console.log(response)
    /* if (!response.ok) {
        return showMsg(store, response.data.error_msg || 'Login failed')
    } */
    const token = response.data.token
    /* saveCookie('token', token)
    store.dispatch('getUserInfo') */
    store.commit(LOGIN_SUCCESS, { token: token })
    /* showMsg(store, 'Sign in success, welcome!', 'success')
    router.push({ path: '/' }) */
  }, response => {
    console.log(response)
    // showMsg(store, response.data.error_msg || 'Login failed')
  })
}
