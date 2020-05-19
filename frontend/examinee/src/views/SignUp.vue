<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <h2>Sign Up</h2>
      </div>
    </div>
    <div style="margin-top:30px"></div>
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <form v-on:submit.prevent>
          <div class="form-group">
            <label for="usr">Email</label>
            <input
              type="text"
              class="form-control"
              id="email"
              name="email"
              placeholder="enter email"
              v-model="examinee.email"
            />
          </div>
          <div class="form-group">
            <label for="name">Name</label>
            <input
              type="text"
              class="form-control"
              id="name"
              name="name"
              placeholder="enter name"
              v-model="examinee.name"
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
              v-model="examinee.password"
            />
          </div>
          <div class="form-group">
            <label for="pwd">Confirm Password</label>
            <input
              type="password"
              class="form-control"
              id="confirm-pwd"
              name="confirm-password"
              placeholder="confirm password"
              v-model="examinee.confirmPassword"
            />
          </div>
          <button @click="registerUser()" type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      examinee: {
        email: '',
        name: '',
        password: '',
        confirmPassword: '',
        role: 1
      }
    }
  },
  methods: {
    registerUser() {
      axios
        .post(`${process.env.API_URL}/register`, this.examinee)
        .then(response => {
          console.log(response);
          if (response.status == 201) {
            alert("Registered");
            this.$router.push('/login');
          } else {
            alert("response status not OK from server");
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