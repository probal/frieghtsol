import lazyLoading from '@/services/lazyLoading'

export default {
  name: 'MyProfile',
  path: '/myprofile',
  component: lazyLoading('auth/profile/Profile'),
  meta: {
    title: 'My Profile',
    iconClass: 'vuestic-icon vuestic-icon-dashboard',
    notInMenu: true
  }
}
