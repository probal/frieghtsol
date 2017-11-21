import Alert from './custom-alert/CustomAlert.vue'
import Scrollbar from './custom-scrollbar/CustomScrollbar.vue'
import ProfileCard from './custom-profile-card/CustomProfileCard.vue'
import Widget from './custom-widget/CustomWidget.vue'
import SimpleSelect from './custom-simple-select/CustomSimpleSelect.vue'
import Tabs from './custom-tabs/CustomTabs.vue'

const CustomComponentsPlugin = {
  install (Vue, options) {
    Vue.component(Alert.name, Alert)
    Vue.component(Scrollbar.name, Scrollbar)
    Vue.component(ProfileCard.name, ProfileCard)
    Vue.component(Widget.name, Widget)
    Vue.component(SimpleSelect.name, SimpleSelect)
    Vue.component(Tabs.name, Tabs)
  }
}

export default CustomComponentsPlugin
