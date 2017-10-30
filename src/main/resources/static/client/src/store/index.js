import Vue from 'vue'
import Vuex from 'vuex'
import createLogger from 'vuex/dist/logger'
import auth from './modules/auth'
import globalVal from './modules/global.val'
import options from './modules/options'
import showmsg from './modules/showmsg'
import * as actions from './actions'
import * as getters from './getters'


const debug = process.env.NODE_ENV !== 'production'
Vue.use(Vuex)

export default new Vuex.Store({
    actions,
    getters,
    modules: {
        auth,
        globalVal,
        options,
        showmsg
    },
    strict: debug,
    plugins: debug ? [createLogger()] : []
})