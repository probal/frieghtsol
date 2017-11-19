import * as actions from './actions'
import * as getters from './getters'
import {
  TOGGLE_EXPAND_MENU_ITEM
} from './mutation-types'

import dashboard from './items/dashboard'
import auth from './items/auth'

const state = {
  items: [
    dashboard,
    auth
  ]
}

const mutations = {
  [TOGGLE_EXPAND_MENU_ITEM] (state, payload) {
    let menuItem = payload.menuItem
    let expand = payload.expand
    if (menuItem.children && menuItem.meta) {
      menuItem.meta.expanded = expand
    }
  }
}

export default {
  state,
  mutations,
  actions,
  getters
}
