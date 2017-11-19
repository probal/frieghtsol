<template>
  <div class="login">
    <h2>Welcome!</h2>
    <form name="login" @submit.prevent="login()" novalidate>
      <div class="form-group">
        <div class="input-group">
          <input type="text" id="email" v-model="user.email" v-validate="'required|email|min:3'" data-vv-delay="100"/>
          <label class="control-label" for="email">Email</label><i class="bar"></i>
        </div>
      </div>
      <div class="form-group">
        <div class="input-group">
          <input type="password" id="password" v-model="user.password" v-validate="'required|min:5'"/>
          <label class="control-label" for="password">Password</label><i class="bar"></i>
        </div>
      </div>
      <div class="d-flex flex-column flex-lg-row align-items-center justify-content-between down-container">
        <button class="btn btn-primary" type="submit">
          Log In
        </button>
        <router-link class='link' :to="{name: 'Signup'}">Create account</router-link>
      </div>
    </form>
  </div>
</template>

<script>
  import { mapActions } from 'vuex'
  
  export default {
    name: 'login',
    data () {
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
      login () {
        let $this = this
        this.$validator.validateAll().then(result => {
          if (result) {
            $this.localLogin($this.user)
          }
        }).catch(() => {
          // Error
        })
      }
    }
  }
</script>

<style lang="scss">
  @import "../../../sass/variables";
  @import "../../../../node_modules/bootstrap/scss/functions";
  @import '../../../../node_modules/bootstrap/scss/mixins/breakpoints';
  @import '../../../../node_modules/bootstrap/scss/variables';

  .login {
    @include media-breakpoint-down(md) {
      width: 100%;
      padding-right: 2rem;
      padding-left: 2rem;
      .down-container {
        .link {
          margin-top: 2rem;
        }
      }
    }

    h2 {
      text-align: center;
    }
    width: 21.375rem;

    .down-container {
      margin-top: 3.125rem;
    }
  }
</style>
