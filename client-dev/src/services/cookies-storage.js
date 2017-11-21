import Cookies from 'universal-cookie'
// import { CookieDomain } from '../config.js'

const cookies = new Cookies()

let cookieConfig = {}
/* if (CookieDomain !== '') {
  cookieConfig = { domain: CookieDomain } // path:'/',maxAge:365*24*60*60
} */

function saveCookie (name, value, config = cookieConfig) {
  cookies.set(name, value, config)
}

function getCookie (name) {
  return cookies.get(name)
}

function removeCookie (name, config = cookieConfig) {
  cookies.remove(name, config)
}

export {
  saveCookie,
  getCookie,
  removeCookie
}
