import * as actions from './actions'
import * as getters from './getters'
import {
    LOGIN_SUCCESS,
    LOGOUT_USER,
    SIGNUP_SUCCESS,
    UPDATE_USER_SUCCESS
} from './mutation-types'

import { getToken } from '@/services/auth'

const state = {
  token: getToken() || null,
  user: null
}

const mutations = {
  [LOGIN_SUCCESS] (state, action) {
    state.token = action.token
  },
  [LOGOUT_USER] (state, action) {
    state.token = null
    state.user = null
  },
  [SIGNUP_SUCCESS] (state, action) {
    console.log('success signup')
    state.token = null
    state.user = null
  },
  [UPDATE_USER_SUCCESS] (state, action) {
    state.user = action.user
  }
}

export default {
  state,
  mutations,
  actions,
  getters
}
