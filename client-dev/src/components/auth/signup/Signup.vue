<template>
  <div class="signup">
    <h2>Create New Account</h2>
    <form name="signup" @submit.prevent="signup()">
      <div class="form-group">
        <div class="input-group">
          <input type="text" id="fullName" v-model="user.fullName" v-validate="'required|min:3'" data-vv-delay="100"/>
          <label class="control-label" for="fullName">Full name</label><i class="bar"></i>
        </div>
      </div>
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
      <div class="form-group">
          <div class="input-group">
            <input type="text" id="phoneNumber" v-model="user.phoneNumber"/>
            <label class="control-label" for="phoneNumber">Phone number</label><i class="bar"></i>
          </div>
        </div>
      <div class="abc-checkbox abc-checkbox-primary">
        <input id="checkbox1" type="checkbox" checked v-model="confirmTerms">
        <label for="checkbox1">
          <span class="abc-label-text">I agree to <router-link to="">Terms of Use.</router-link></span>
        </label>
      </div>
      <div class="d-flex flex-column flex-lg-row align-items-center justify-content-between down-container">
        <button class="btn btn-primary" type="submit">
          Sign Up
        </button>
        <router-link class='link' :to="{name: 'Login'}">Already joined?</router-link>
      </div>
    </form>
  </div>
</template>

<script>
  import { mapActions } from 'vuex'

  export default {
    name: 'signup',
    data () {
      return {
        user: {
          fullName: '',
          email: '',
          password: '',
          phoneNumber: ''
        },
        confirmTerms: true
      }
    },
    methods: {
      ...mapActions([
        'localSignup'
      ]),
      signup () {
        let $this = this
        if (this.confirmTerms) {
          console.log('term')
          this.$validator.validateAll().then(result => {
            if (result) {
              $this.localSignup($this.user)
            }
          }).catch(() => {
            // Error
          })
        }
      }
    }
  }
</script>

<style lang="scss">
  @import "../../../sass/variables";
  @import "../../../../node_modules/bootstrap/scss/functions";
  @import '../../../../node_modules/bootstrap/scss/mixins/breakpoints';
  @import '../../../../node_modules/bootstrap/scss/variables';

  .signup {
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
      margin-top: 2.6875rem;
    }
  }
</style>
