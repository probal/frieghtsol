import * as actions from './actions'
import * as getters from './getters'
import {
    LOGIN_SUCCESS,
    LOGOUT_USER
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
  } /* ,
  [UPDATE_USER_SUCCESS] (state, action) {
    state.user = action.user
  } */
}

export default {
  state,
  mutations,
  actions,
  getters
}
