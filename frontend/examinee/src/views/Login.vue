<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <h2>Login</h2>
      </div>
    </div>
    <div style="margin-top:30px"></div>
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <form v-on:submit.prevent>
          <div class="form-group">
            <label for="email">Email</label>
            <input
              type="email"
              class="form-control"
              id="email"
              name="email"
              placeholder="enter email"
              ref="email" 
            />
          </div>
          <div class="form-group">
            <label for="pwd">Password</label>
            <input
              type="password"
              class="form-control"
              id="pwd"
              name="password"
              placeholder="enter password"
              ref="pwd" 
            />
          </div>
          <button @click="login()" class="btn btn-primary">Submit</button>
        </form>
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
  created() {
    if (this.loggedIn) {
      this.$router.push("/home");
    }
  },
  methods: {
    login() {
      let loginCondition = this.$refs.email.value == 'vinh@gmail.com' && this.$refs.pwd.value == '123'; // TODO: will implement in future
      if (loginCondition) {
        this.$store.dispatch("updateLoggedIn", true);
        this.$router.push("/home");
      } else {
        alert("wrong username or password");
      }
    }
  }
};
</script>