import {saveCookie, removeCookie, getCookie} from './cookies-storage'
import {saveLocal, getLocal, removeLocal} from './local-storage'

const tokenName = 'jwttoken'
const meStoreKeyName = '__I#'

export function signOut (config) {
  removeCookie(tokenName, config)
}

export function isLogin () {
  return !!getCookie(tokenName)
}

export function setToken (token) {
  saveCookie(tokenName, token)
}

export function getToken () {
  return getCookie(tokenName)
}

export function setMe (me) {
  saveLocal(meStoreKeyName, me)
}

export function getMe () {
  return getLocal(meStoreKeyName)
}

export function removeMe () {
  removeLocal(meStoreKeyName)
}
