<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4">
        <h2>Profile</h2>
      </div>
    </div>
    <div style="margin-top:10px"></div>
    <div class="row">
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
              disabled
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
              :disabled="saved"
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
              :disabled="saved"
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
              :disabled="saved"
            />
          </div>
          <button v-if="saved" style="width: 140px;" type="submit" @click="edit()" class="btn btn-primary btn-lg">Edit</button>
          <button v-if="!saved" style="width: 140px;" type="submit" @click="save()" class="btn btn-primary btn-lg">Save</button>
        </form>
      </div>
    </div>
    <div style="margin-top:10px"></div>

    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <button @click="logout()" style="width: 160px;" class="btn btn-primary btn-lg">Logout</button>
        <button @click="viewAchivement()" style="width: 160px;" class="btn btn-primary btn-lg">Achivement</button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import axios from "axios";

export default {  
  data() {
    return {
      examinee: null,
      saved: true
    }
  },
  computed: {
    ...mapGetters({
      loggedIn: 'getLoggedIn',
    })
  },
  created() {
    if(!this.loggedIn) {
      this.$router.push('/login');
    } else {
      this.examinee = JSON.parse(localStorage.getItem('examinee'));
      this.examinee.confirmPassword = this.examinee.password;
    }
  },
  methods: {
    edit() {
      this.saved = false;
    },
    save() {
      axios
        .put(`${process.env.API_URL}/edit-profile/${this.examinee.id}`, this.examinee)
        .then(response => {
          console.log(response);
          if (response.status == 200) {
            this.saved = true;
            localStorage.setItem('examinee', JSON.stringify(this.examinee));
            alert("Saved");
            this.$router.go(0);
          } else {
            alert("response status not OK from server");
          }
        })
        .catch(e => {
          console.log(e.response);
          alert(e.response.data);
          //this.errors.push(e)
        });
    },
    logout() {
      localStorage.removeItem('examinee');
      this.$store.dispatch('updateLoggedIn', false);
      this.$router.push('/home');
      this.$router.go(0);
    },
    viewAchivement() {
      this.$router.push('/achievement')
    }
  }
};
</script>