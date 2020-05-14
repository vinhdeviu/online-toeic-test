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
            <label for="name">Name</label>
            <input
              type="text"
              class="form-control"
              id="name"
              name="name"
              placeholder="enter name"
              value="Nguyen Duy Vinh"
            />
          </div>
          <div class="form-group">
            <label for="usr">Email</label>
            <input
              type="email"
              class="form-control"
              id="email"
              name="email"
              placeholder="enter email"
              value="dacnhantam1607@gmail.com"
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
              value="Nguyen Duy Vinh"
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
              value="Nguyen Duy Vinh"
            />
          </div>
          <button style="width: 140px;" type="submit" class="btn btn-primary btn-lg">Save</button>
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

export default {
  computed: {
    ...mapGetters({
      loggedIn: 'getLoggedIn',
    })
  },
  created() {
    if(!this.loggedIn) {
      this.$router.push('/login')
    }
  },
  methods: {
    logout() {
      this.$store.dispatch('updateLoggedIn', false)
      this.$router.push('/home')
    },
    viewAchivement() {
      this.$router.push('/achievement')
    }
  }
};
</script>