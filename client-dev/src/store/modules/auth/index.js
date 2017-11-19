import * as actions from './actions'
import * as getters from './getters'
import {
    LOGIN_SUCCESS,
    LOGOUT_USER,
    SIGNUP_SUCCESS
} from './mutation-types'

import { getCookie } from '@/services/auth'

const state = {
  token: getCookie('token') || null,
  user: null
}

const mutations = {
  [LOGIN_SUCCESS] (state, action) {
    state.token = action.token
  },
  [LOGOUT_USER] (state, action) {
    state.token = getCookie('token') || null
    state.user = null
    state.token = null
  },
  [SIGNUP_SUCCESS] (state, action) {
    console.log('success signup')
  }
  /* [UPDATE_USER_SUCCESS] (state, action) {
    state.user = action.user
  } */
}

export default {
  state,
  mutations,
  actions,
  getters
}
