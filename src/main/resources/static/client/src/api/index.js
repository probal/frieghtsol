import { UserResource, AuthResource } from './resources'

export default {
    localLogin: function(data) {
        return AuthResource.save({ id: 'local' }, data)
    },
    getMe: function() {
        return UserResource.get({ id: 'me' })
    },
    mdUser: function(data) {
        return UserResource.update({ id: 'mdUser' }, data)
    }
}