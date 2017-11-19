const sidebarOpened = state => state.sidebar.opened
const toggleWithoutAnimation = state => state.sidebar.withoutAnimation
const config = state => state.config
const palette = state => state.config.palette
const isLoading = state => state.isLoading

export {
  toggleWithoutAnimation,
  sidebarOpened,
  config,
  palette,
  isLoading
}
