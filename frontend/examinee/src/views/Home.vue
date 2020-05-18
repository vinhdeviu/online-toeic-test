<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <h2>Take A TOEIC Mock Test</h2>
      </div>
    </div>
    <div style="margin-top:80px"></div>
    <div class="row" v-for="testChunk in testChunks" :key="testChunk.id">
      <div class="col-sm-4" v-for="test in testChunk" :key="test.id">
        <button @click="doTest(test.id)" class="btn btn-primary btn-block">{{test.testName}}</button>
        <div style="margin-top:20px"></div>
      </div>
    </div>
  </div>
</template>

<script>
import _ from 'lodash'
import axios from "axios";
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      tests: []
    }
  },
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn"
    }),
    testChunks() {
      return _.chunk(Object.values(this.tests), 3);
    }
  },
  created() {
    axios.get(`${process.env.API_URL}/tests`).then(response => {
        this.tests = response.data;
        console.log(this.tests);
      });
  },
  methods: {
    doTest(testId) {
      if (this.loggedIn) {
        this.$router.push(`/test/${testId}`);
      } else {
        alert("please login first");
        this.$router.push("/login");
      }
    }
  }
};
</script>