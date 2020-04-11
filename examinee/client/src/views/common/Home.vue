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
        <button @click="doTest()" class="btn btn-primary btn-block">Easy</button>
      </div>
      <div class="col-sm-4">
        <button @click="doTest()" class="btn btn-primary btn-block">Normal</button>
      </div>
      <div class="col-sm-4">
        <button @click="doTest()" class="btn btn-primary btn-block">Hard</button>
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
    doTest() {
      if (this.loggedIn) {
        this.$router.push("/test");
      } else {
        alert("please login first");
        this.$router.push("/login");
      }
    }
  }
};
</script>