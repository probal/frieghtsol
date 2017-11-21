<template>
  <div class="profile">
    <div class="row">
      <div class="col-md-4 d-flex">
        <custom-widget headerText="Profile Card" class="profile-card-widget">
          <custom-profile-card :name="loggedInUser.name" :location="'Malaga, Spain'" :email="loggedInUser.email"
                                :social="{twitter: 'twitter.com', facebook: 'facebook.com',
                                  instagram: 'instagram.com'}">
          </custom-profile-card>
        </custom-widget>
      </div>
      <div class="col-md-8 d-flex">
        <custom-widget class="no-v-padding settings-card-widget">
            <custom-tabs class="tabs" :names="['Edit', 'Change Password', 'Settings']">
              <div slot="Edit" class="d-flex justify-content-center">
                <profile-edit-form />
              </div>
              <div slot="Change Password" class="d-flex justify-content-center">
                <change-password />
              </div>
              <div slot="Settings" class="d-flex justify-content-center">
                <profile-settings />
              </div>
            </custom-tabs>
        </custom-widget>
      </div>
    </div>
  </div>
</template>

<script>
  import ChangePassword from './ChangePassword'
  import ProfileEditForm from './ProfileEdit'
  import ProfileSettings from './ProfileSettings'
  import { mapGetters } from 'vuex'

  export default {
    name: 'profile',
    components: {
      ChangePassword,
      ProfileEditForm,
      ProfileSettings
    },
    computed: {
      ...mapGetters([
        'loggedInUser'
      ])
    }
  }
</script>

<style lang="scss">
  .tabs {
    .overview-tab {
      .explore-row {
        display: none !important;
      }
    }
  }

  .profile-card-widget, .settings-card-widget {
    width: 100%;
  }
  .profile-card-widget {
    .widget-body {
      display: flex;
      justify-content: center;
      align-items: center;
      & > div {
        width: 100%;
      }
    }
  }
</style>
  