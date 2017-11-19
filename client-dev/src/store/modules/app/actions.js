import {
  CLOSE_MENU,
  TOGGLE_SIDEBAR,
  TOGGLE_WITHOUT_ANIMATION
} from './mutation-types'

export function closeMenu ({ commit }) {
  commit(CLOSE_MENU)
}

export function toggleSidebar ({ commit }, opened) {
  commit(TOGGLE_SIDEBAR, opened)
}

export function isToggleWithoutAnimation ({ commit }, value) {
  commit(TOGGLE_WITHOUT_ANIMATION, value)
}
