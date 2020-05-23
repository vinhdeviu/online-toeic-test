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
import axios from "axios";

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
      let user = {
        email: this.$refs.email.value,
        password: this.$refs.pwd.value
      }
      axios
        .post(`${process.env.API_URL}/examinee-login`, user)
        .then(response => {
          if(response.status == 200) {
            console.log(response);
            let examinee = response.data;
            localStorage.setItem('examinee', JSON.stringify(examinee));
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