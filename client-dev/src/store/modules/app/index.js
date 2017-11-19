import * as actions from './actions'
import * as getters from './getters'
import {
  CLOSE_MENU,
  TOGGLE_SIDEBAR,
  TOGGLE_WITHOUT_ANIMATION

} from './mutation-types'

const state = {
  sidebar: {
    opened: false,
    withoutAnimation: false
  },
  config: {
    googleMaps: {
      apiKey: 'AIzaSyBNAqPrTQoz9P4NBlDDyfxrnKiafkaL8iQ'
    },
    windowMatchSizeLg: '(min-width: 992px)',
    palette: {
      primary: '#57bef3',
      danger: '#e34a4a',
      info: '#4ab2e3',
      success: '#4fce91',
      warning: '#f7cc36',
      white: '#fff',
      black: '#000',
      fontColor: '#34495e',
      transparent: 'transparent',
      lighterGray: '#ddd'
    }
  },
  isLoading: true
}

const mutations = {
  [CLOSE_MENU] (state) {
    if (document.documentElement.clientWidth < 992) {
      state.sidebar.opened = false
    }
  },
  [TOGGLE_SIDEBAR] (state, opened) {
    state.sidebar.opened = opened
  },
  [TOGGLE_WITHOUT_ANIMATION] (state, value) {
    state.sidebar.withoutAnimation = value
  },
  setLoading (state, isLoading) {
    state.isLoading = isLoading
  }
}

export default {
  state,
  mutations,
  actions,
  getters
}
