<template>
    <div class="signin-box">
      <div class="signin-container">
        <h4 class="title">Log In</h4>
        <div id="signinForm">
          <form class="signin-form form-horizontal" @submit.prevent="login()" novalidate>
            <div class="form-group">
              <div class="input-group">
                <div class="input-group-addon">
                  <i class="fa fa-envelope-o"></i>
                </div>
                <input type="text" name="email" v-model="user.email" v-validate="'required|email|min:3'" data-vv-delay="100" class="form-control" placeholder="Email"></input>
              </div>
            </div>
            <div class="form-group">
              <div class="input-group">
                <div class="input-group-addon"><i class="fa fa-unlock-alt"></i></div>
                <input type="password" name="password" v-model="user.password" v-validate="'required|min:5'" class="form-control" placeholder="Password"></input>
              </div>
            </div>
            <div class="form-group">
              <button class="btn btn-primary btn-lg btn-block" type="submit" id="signin_btn">Login</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </template>

<script>
    import {
        Validator
    } from 'vee-validate'

    import {
        mapState,
        mapActions
    } from 'vuex'
    export default {
        computed: {
            ...mapState({
                token: ({ auth }) => auth.token
            })
        },
        data() {
            return {
                user: {
                    email: '',
                    password: ''
                }
            }
        },
        methods: {
            ...mapActions([
                'localLogin'
            ]),
            login() {
                this.$validator.validateAll().then(result => {
                    if (result) {
                        this.localLogin(this.user)
                    }
                }).catch(() => {
                    //Error
                })
            }
        }
    }
    //:disabled="!fields.valid()"
</script>