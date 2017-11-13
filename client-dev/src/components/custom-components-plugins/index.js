import Alert from './custom-alert/CustomAlert.vue'
import Scrollbar from './custom-scrollbar/CustomScrollbar.vue'

const CustomComponentsPlugin = {
  install (Vue, options) {
    Vue.component(Alert.name, Alert)
    Vue.component(Scrollbar.name, Scrollbar)
  }
}

export default CustomComponentsPlugin
