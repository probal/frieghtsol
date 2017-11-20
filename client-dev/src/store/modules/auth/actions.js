import { AuthResource } from '@/api/resources'

import {
  LOGOUT_USER,
  LOGIN_SUCCESS,
  SIGNUP_SUCCESS,
  UPDATE_USER_SUCCESS
} from './mutation-types'
import { signOut, getToken, setMe, removeMe } from '@/services/auth'

import router from '@/router'

export function logout ({ commit }) {
  signOut()
  removeMe()
  commit(LOGOUT_USER)
  router.push({ path: '/login' })
}

export function localLogin (store, userInfo) {
  AuthResource.save({ id: 'doLogin' }, userInfo).then(response => {
    console.log(response)
    if (!response.ok) {
      return // showMsg(store, response.data.error_msg || 'Login failed')
    }
    setMe(response.data)

    store.commit(LOGIN_SUCCESS, {token: getToken()})
    store.commit(UPDATE_USER_SUCCESS, { user: response.data })
    // showMsg(store, 'Sign in success, welcome!', 'success')
    router.push({ path: '/' })
  }, response => {
    console.log('error', response)
    // showMsg(store, response.data.error_msg || 'Login failed')
  })
}

export function localSignup (store, userInfo) {
  AuthResource.save({ id: 'register' }, userInfo).then(response => {
    console.log(response)
    if (!response.ok) {
      return // showMsg(store, response.data.error_msg || 'Login failed')
    }
    store.commit(SIGNUP_SUCCESS)
    // showMsg(store, 'Sign in success, welcome!', 'success')
    router.push({ path: '/login' })
  }, response => {
    console.log('error', response)
    // showMsg(store, response.data.error_msg || 'Login failed')
  })
}
