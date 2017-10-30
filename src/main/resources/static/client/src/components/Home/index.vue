<template>
    <div>
      <div class="container-fluid main-box">
        <div class="row">
          <div class="col-sm-7 col-sm-offset-3 main-content">
            <h1>Home Page</h1>
          </div>
        </div>
      </div>
      <Footerbar></Footerbar>
    </div>
</template>
<script>
    import Footerbar from './footer.vue'
    import {
        mapState,
        mapActions
    } from 'vuex'
    export default {
        components: {
            Footerbar
        }
    }
</script>