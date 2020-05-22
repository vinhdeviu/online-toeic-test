<template>
  <div class="limiter">
    <div class="container-login100">
      <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
        <form class="login100-form validate-form" v-on:submit.prevent>
          <span class="login100-form-title p-b-33">Account Login</span>

          <div
            class="wrap-input100 validate-input"
            data-validate="Valid email is required: ex@abc.xyz"
          >
            <input class="input100" type="text" id="email" name="email" placeholder="Email" v-model="admin.email"/>
            <span class="focus-input100-1"></span>
            <span class="focus-input100-2"></span>
          </div>

          <div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
            <input class="input100" type="password" id="password" name="password" placeholder="Password" v-model="admin.password" />
            <span class="focus-input100-1"></span>
            <span class="focus-input100-2"></span>
          </div>

          <div class="container-login100-form-btn m-t-20">
            <button class="login100-form-btn" @click="login()">Sign in</button>
          </div>

          <!-- <div class="text-center p-t-45 p-b-4">
            <span class="txt1">Forgot</span>

            <a href="#" class="txt2 hov1">Username / Password?</a>
          </div>

          <div class="text-center">
            <span class="txt1">Create an account?</span>

            <a href="#" class="txt2 hov1">Sign up</a>
          </div> -->
        </form>
      </div>
    </div>
  </div>
</template>

<style>
  @import '../static/css/main.css';
  @import '../static/css/util.css';
</style>

<script>
import { mapGetters } from "vuex";
import axios from "axios";

export default {
  data() {
    return {
      admin: {
        email: '',
        password: ''
      }
    }
  },
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn"
    })
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/home");
    }
  },
  methods: {
    login() {
      const API_URL = `${process.env.API_URL}/admin-login`;
      axios
        .post(API_URL, this.admin)
        .then(response => {
          if(response.status == 200) {
            console.log(response);
            let admin = response.data;
            localStorage.setItem('admin', JSON.stringify(admin));
            this.$store.dispatch("updateAdmin", Object.assign({}, admin));
            this.$store.dispatch("updateLoggedIn", true);
            this.$router.push("/home");
          } else {
            alert("Response status not OK from server");
          }
        })
        .catch(e => {
          console.log(e.response);
          alert(e.response.data);
          //this.errors.push(e)
        });
    }
  }
};
</script>