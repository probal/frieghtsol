import Vue from 'vue'
import Vuex from 'vuex'
import createLogger from 'vuex/dist/logger'

import menu from './modules/menu'
import auth from './modules/auth'
import app from './modules/app'

const debug = process.env.NODE_ENV !== 'production'
Vue.use(Vuex)

export default new Vuex.Store({
  strict: debug,
  plugins: debug ? [createLogger()] : [],
  modules: {
    menu,
    auth,
    app
  }
})

