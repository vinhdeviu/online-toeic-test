<template>
  <div class="jumbotron text-center">
    <div class="row">
      <div class="col-sm-4">
        <h1 @click="goHome()" style="cursor:pointer">Online Toeic Test</h1>
      </div>
      <test></test>
      <div class="col-sm-4">
        <button v-if="!loggedIn" @click="login()" class="btn btn-primary">Login</button>
        <button v-if="!loggedIn" @click="signUp()" class="btn btn-primary">Sign up</button>
        <button v-if="loggedIn" @click="viewProfile()" class="btn btn-primary">Nguyen Duy Vinh</button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Test from "./Test.vue";

export default {
  components: {
    test: Test
  },
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