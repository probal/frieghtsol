import * as actions from './actions'
import * as getters from './getters'
import {
  TOGGLE_EXPAND_MENU_ITEM
} from './mutation-types'

import common from './items/common'
import dashboard from './items/dashboard'
import auth from './items/auth'
import myprofile from './items/myprofile'

const state = {
  items: [
    common,
    dashboard,
    auth,
    myprofile
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
