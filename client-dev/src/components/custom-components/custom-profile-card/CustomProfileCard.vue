<template>
    <div class="custom-profile-card d-flex flex-column align-items-center">
      <div class="photo">
          <v-gravatar :email="email" default-img="mm" :size="150" />
      </div>
      <h5 class="name">{{name}}</h5>
      <span class="location"><span class="icon fa fa-map-marker"></span> {{location}}</span>
      <div class="social">
        <a class="icon fa fa-facebook"
           v-if="social.facebook" :href="'http://' + social.facebook" target="_blank"></a>
        <a class="icon fa fa-instagram"
           v-if="social.instagram" :href="'http://' + social.instagram" target="_blank"></a>
        <a class="icon fa fa-twitter"
           v-if="social.twitter" :href="'http://' + social.twitter" target="_blank"></a>
      </div>
    </div>
  </template>
  
  <script>
    import VGravatar from 'vue-gravatar'
    export default {
      name: 'custom-profile-card',
      props: ['email', 'name', 'location', 'social'],
      components: {
        VGravatar
      }
    }
  </script>
  
  <style lang="scss">
    @import "../../../sass/variables";
  
    $custom-profile-card-width: 12.6875rem;
    $custom-profile-card-photo-diameter: 9.375rem;
  
    .custom-profile-card {
      width: $custom-profile-card-width;
      .photo {
        height: $custom-profile-card-photo-diameter;
        width: $custom-profile-card-photo-diameter;
        border-radius: 50%;
        background-color: $lighter-gray;
        overflow: hidden;
  
        img {
          height: 100%;
          width: 100%;
        }
      }
      .name {
        margin-top: 1.325rem;
        margin-bottom: 0;
      }
      .location {
        margin-top: 0.8125rem;
        .icon {
          color: $lighter-gray;
          font-size: $font-size-larger;
          padding: 0 0.2rem;
        }
        &:hover {
          cursor: pointer;
          .icon {
            color: red;
          }
        }
      }
      .social {
        display: flex;
        justify-content: center;
        padding-top: 1rem;
        margin-top: 1.25rem;
        width: 100%;
        border-top: solid .125rem $light-gray;
        .icon {
          color: $gray;
          text-decoration: none;
          font-size: $h4-font-size;
          margin-right: .4375rem;
          margin-left: .4375rem;
          &:hover {
            cursor: pointer;
            color: darken($gray, 50%);
          }
        }
      }
    }
  </style>
  