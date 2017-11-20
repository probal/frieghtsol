import Cookies from 'universal-cookie'
import LocalStorage from 'local-storage'
import Utils from '@/services/utils'
import { CookieDomain } from '../config.js'

const cookies = new Cookies()
const tokenName = 'jwttoken'
const meStoreKeyName = '__I#'

let cookieConfig = {}
if (CookieDomain !== '') {
  cookieConfig = { domain: CookieDomain } // path:'/',maxAge:365*24*60*60
}

export function saveCookie (name, value) {
  cookies.set(name, value, cookieConfig)
}

export function getCookie (name) {
  return cookies.get(name)
}

export function removeCookie (name) {
  cookies.remove(name, cookieConfig)
}

export function signOut () {
  removeCookie(tokenName)
}

export function isLogin () {
  return !!getCookie(tokenName)
}

export function getToken () {
  return getCookie(tokenName)
}

export function setMe (me) {
  LocalStorage.set(meStoreKeyName, Utils.json2b64({ts: Date.now(), d: me}))
}

export function getMe () {
  let me = Utils.b642json(LocalStorage.get(meStoreKeyName))
  return me.d
}

export function removeMe () {
  LocalStorage.remove(meStoreKeyName)
}
