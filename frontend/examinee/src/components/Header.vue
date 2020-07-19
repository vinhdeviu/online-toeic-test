<template>
  <div class="jumbotron text-center" style ="padding-top: 2%;padding-bottom: 2%;" id="header">
    <div class="row">
      <div class="col-sm-4">
        <h1 @click="goHome()" style="cursor:pointer">Online Toeic Test</h1>
      </div>
      <testInfor></testInfor>
      <div class="col-sm-4">
        <button v-if="!loggedIn" @click="login()" class="btn btn-primary">Login</button>
        <button v-if="!loggedIn" @click="signUp()" class="btn btn-primary">Sign up</button>
        <button v-if="loggedIn" @click="viewProfile()" class="btn btn-primary">{{examinee.name}}</button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import TestInfor from "./TestInfor.vue";

export default {
  data() {
    return {
      examinee: null
    }
  },
  components: {
    testInfor: TestInfor
  },
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn"
    })
  },
  created() {
    this.examinee = JSON.parse(localStorage.getItem('examinee'));
  },
  methods: {
    login() {
      this.$router.push("/login");
    },
    signUp() {
      this.$router.push("/sign-up");
    },
    viewProfile() {
      this.$router.push(`/profile`);
    },
    goHome() {
      this.$router.push("/home");
    }
  },
  watch: {
    loggedIn: function (newValue, oldValue) {
      this.examinee = JSON.parse(localStorage.getItem('examinee'));
    }
  }
};
</script>