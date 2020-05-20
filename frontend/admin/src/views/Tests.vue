<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <h1>Test Data</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-2">
        <div class="line"></div>
      </div>
      <div class="col-sm-8"></div>
      <!-- <div class="col-sm-2">
        <div class="md-form mt-0">
          <input class="form-control" type="text" placeholder="Search" aria-label="Search" />
        </div>
      </div> -->
    </div>

    <div class="table-wrapper-scroll-y my-custom-scrollbar"
      :style="{height: (tests.length>6?450:35+tests.length*100*0.6) + 'px'}"
    >
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
              <button @click="checkTest(test.id)" class="btn btn-primary btn-sm">Check Detail</button>
            </td>
            <td>
              <button @click="deleteTest(test.id)" class="btn btn-danger btn-sm">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button style="margin-top:10px" @click="addNewTest()" class="btn btn-primary">Add New Test</button>
  </div>
</template>

<script>
import axios from "axios";
import { deleteObjectByIdFromArray } from "../helper";

export default {
  data() {
    return {
      tests: []
    };
  },
  created() {
    axios.get(`${process.env.API_URL}/tests`).then(response => {
      this.tests = response.data;
      console.log(this.tests);
    });
  },
  methods: {
    checkTest(testId) {
      this.$router.push(`/tests/${testId}`);
    },
    deleteTest(testId) {
      const confirm = window.confirm("Are you sure you want to delete it?");
      if (confirm) {
        axios
          .delete(`${process.env.API_URL}/tests/${testId}`)
          .then(response => {
            console.log(response);
            if (response.status == 204) {
              alert("Test deleted successfully");
              deleteObjectByIdFromArray(this.tests, testId);
            } else {
              alert("response status not OK from server");
            }
          })
          .catch(e => {
            console.log(e);
            console.log(e.response);
            alert(e.response.data);
            //this.errors.push(e)
          });
      }
    },
    addNewTest() {
      this.$router.push(`/new-test`);
    }
  }
};
</script>