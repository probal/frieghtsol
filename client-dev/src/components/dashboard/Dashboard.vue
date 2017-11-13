<template>
  <div class="dashboard">
    <div class="row">
      <div class="col-md-12">
        <custom-alert type="success" :withCloseBtn="true">
          <span class="badge badge-pill badge-success">SUCCESS</span>
          You successfully read this important alert message.
          <i class="fa fa-close alert-close"></i>
        </custom-alert>
      </div>
    </div>

    <div class="row">
      <div class="col">
        <h2>Hello World!</h2>
      </div>
    </div>

  </div>
</template>

<script>
  import CustomAlert from '../custom-components-plugins/custom-alert/CustomAlert'

  export default {
    name: 'dashboard',
    components: {
      CustomAlert
    }
  }
</script>

<style lang="scss" scoped>
  @import "../../sass/_variables.scss";
</style>
