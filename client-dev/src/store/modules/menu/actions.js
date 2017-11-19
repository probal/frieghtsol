import {
  TOGGLE_EXPAND_MENU_ITEM
} from './mutation-types'

export function toggleExpandMenuItem ({commit}, payload) {
  commit(TOGGLE_EXPAND_MENU_ITEM, payload)
}
