<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <h2>Take A TOEIC Mock Test</h2>
      </div>
    </div>
    <div style="margin-top:80px"></div>
    <div class="row">
      <div class="col-sm-4">
        <h3>Date</h3>
        <h4>12/10/2020</h4>
        <h4>12/10/2020</h4>
        <h4>12/10/2020</h4>
        <h4>12/10/2020</h4>
      </div>
      <div class="col-sm-4">
        <h3>Difficulty</h3>
        <h4>Easy</h4>
        <h4>Easy</h4>
        <h4>Hard</h4>
        <h4>Hard</h4>
      </div>
      <div class="col-sm-4">
        <h3>Score</h3>
        <h4>20</h4>
        <h4>20</h4>
        <h4>20</h4>
        <h4>20</h4>
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
    if (!this.loggedIn) {
      this.$router.push("/login");
    }
  }
};
</script>