import Vue from 'vue'
import VeeValidate from 'vee-validate'
import { Validator } from 'vee-validate'

Validator.extend('nickname', {
    getMessage: field => 'Please enter the correct nickname (2-15 characters, english, numbers and underscore)',
    validate: value => /^[(\u4e00-\u9fa5)0-9a-zA-Z\_\s@]+$/.test(value)
})

const config = {
    errorBagName: 'errors', // change if property conflicts.
    fieldsBagName: 'fields',
    delay: 0,
    locale: 'en',
    dictionary: null,
    strict: true,
    enableAutoClasses: true,
    classNames: {
        touched: 'touched', // the control has been blurred
        untouched: 'untouched', // the control hasn't been blurred
        valid: 'ng-valid', // model is valid
        invalid: 'ng-invalid', // model is invalid
        pristine: 'pristine', // control has not been interacted with
        dirty: 'ng-dirty' // control has been interacted with
    },
    events: 'input|blur',
    inject: true
}
Vue.use(VeeValidate, config)