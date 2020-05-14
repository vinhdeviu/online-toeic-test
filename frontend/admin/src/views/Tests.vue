<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <h1>Manage Tests</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-2">
        <div class="line"></div>
      </div>
      <div class="col-sm-8"></div>
      <div class="col-sm-2">
        <div class="md-form mt-0">
          <input class="form-control" type="text" placeholder="Search" aria-label="Search" />
        </div>
      </div>
    </div>

    <div class="table-wrapper-scroll-y my-custom-scrollbar">
      <table class="table table-striped mb-0">
        <thead>
          <tr>
            <th>Test Id</th>
            <th>Name</th>
            <th>Audio Link</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="test in tests" :key="test.id">
            <td>{{test.id}}</td>
            <td>{{test.testName}}</td>
            <td>{{test.audioLink}}</td>
            <td>
              <button @click="checkTest(test.id)" class="btn btn-primary btn-sm">Check</button>
            </td>
            <td>
              <button @click="deleteTest(test.id)" class="btn btn-danger btn-sm">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      tests: []
    };
  },
  created() {
    axios.get(`${process.env.API_URL}/tests`).then(response => {
      this.tests = response.data
      console.log(this.tests);
    });
  },
  methods: {
    checkTest(testId) {
      this.$router.push(`/tests/${testId}`);
    },
    deleteTest(testId) {
      // axios.delete(`${process.env.API_URL}/tests/${testId}`).then(response => {
      //   console.log(response);
      // });
    }
  }
};
</script>