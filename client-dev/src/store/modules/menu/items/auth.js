/**
 * Created by yarik on 18.7.17.
 */
import lazyLoading from '@/services/lazyLoading'

export default {
  name: 'auth',
  meta: {
    expanded: false,
    title: 'Auth',
    iconClass: 'vuestic-icon vuestic-icon-auth',
    notInMenu: true
  },
  children: [
    {
      name: 'Login',
      path: '/login',
      component: lazyLoading('auth/login/Login'),
      meta: {
        default: false,
        title: 'Login',
        requiresNotAuth: true
      }
    },
    {
      name: 'Signup',
      path: '/signup',
      component: lazyLoading('auth/signup/Signup'),
      meta: {
        default: false,
        title: 'Signup',
        requiresNotAuth: true
      }
    }
  ]
}
