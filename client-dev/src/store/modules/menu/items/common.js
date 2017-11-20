/**
 * Created by yarik on 18.7.17.
 */
import lazyLoading from '@/services/lazyLoading'

export default {
  name: 'common',
  meta: {
    expanded: false,
    title: 'Common',
    iconClass: '',
    notInMenu: true
  },
  children: [
    {
      name: 'NotFound',
      path: '/404',
      component: lazyLoading('common/404'),
      meta: {
        default: false,
        title: '404'
      }
    },
    {
      name: 'InternalServerError',
      path: '/500',
      component: lazyLoading('common/500'),
      meta: {
        default: false,
        title: '500'
      }
    }
  ]
}
