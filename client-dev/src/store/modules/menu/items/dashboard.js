import lazyLoading from '@/services/lazyLoading'

export default {
  name: 'Dashboard',
  path: '/dashboard',
  alias: '/',
  component: lazyLoading('dashboard/Dashboard'),
  meta: {
    default: true,
    title: 'Dashboard',
    iconClass: 'vuestic-icon vuestic-icon-dashboard'
  }
}
