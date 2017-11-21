import LocalStorage from 'local-storage'
import Utils from './utils'

export function saveLocal (key, value) {
  return LocalStorage.set(key, {ts: Date.now(), d: Utils.json2b64(value)})
}

export function getLocal (key) {
  let value = LocalStorage.get(key)
  return value ? Utils.b642json(value.d) : null
}

export function removeLocal (key) {
  return LocalStorage.remove(key)
}
