import { Http, AuthResource } from '@/api/resources'

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
  Http(AuthResource.save({ state: 'public', id: 'doLogin' }, userInfo)).then(response => {
    const token = getToken()
    if (token) {
      setMe(response)
      store.commit(LOGIN_SUCCESS, {token: token})
      store.commit(UPDATE_USER_SUCCESS, { user: response })
      // showMsg(store, 'Sign in success, welcome!', 'success')
      router.push({ path: '/' })
    }
  }, response => {
    // showMsg(store, response.data.error_msg || 'Login failed')
  })
}

export function localSignup (store, userInfo) {
  Http(AuthResource.save({ state: 'public', id: 'register' }, userInfo)).then(response => {
    store.commit(SIGNUP_SUCCESS)
    // showMsg(store, 'Sign in success, welcome!', 'success')
    router.push({ path: '/login' })
  }, response => {
    // showMsg(store, response.data.error_msg || 'Login failed')
  })
}
