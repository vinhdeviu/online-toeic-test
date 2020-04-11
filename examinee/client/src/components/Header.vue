<template>
  <div class="jumbotron text-center">
    <div class="row">
      <div class="col-sm-4">
        <h1 @click="goHome()">Online Toeic Test</h1>
      </div>
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <button v-if="!this.loggedIn" @click="login()" class="btn btn-primary">Login</button>
        <button v-if="!this.loggedIn" @click="signUp()" class="btn btn-primary">Sign up</button>
        <button v-if="this.loggedIn" @click="viewProfile()" class="btn btn-primary">Nguyen Duy Vinh</button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn"
    })
  },
  methods: {
    login() {
      this.$router.push("/login");
    },
    signUp() {
      this.$router.push("/sign-up");
    },
    viewProfile() {
      this.$router.push("/profile");
    },
    goHome() {
      this.$router.push("/home");
    }
  }
};
</script>