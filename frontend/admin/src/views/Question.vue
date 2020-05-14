<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <h1>Test {{ $route.params.testId }}</h1>
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
            <th>Part Id</th>
            <th>Name</th>
            <th>Part Number</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="part in parts" :key="part.id">
            <td>{{part.id}}</td>
            <td>{{part.tittle}}</td>
            <td>{{part.partNum}}</td>
            <td>
              <button @click="viewPart(part.id)" class="btn btn-success btn-sm">View</button>
            </td>
            <td>
              <button @click="editPart(part.id)" class="btn btn-primary btn-sm">Edit</button>
            </td>
            <td>
              <button @click="deletePart(part.id)" class="btn btn-danger btn-sm">Delete</button>
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
      testId: this.$route.params.testId,
      parts: []
    };
  },
  created() {
    console.log(`${process.env.API_URL}/parts?testId=${this.testId}`)
    axios.get(`${process.env.API_URL}/parts?testId=${this.testId}`).then(response => {
      this.parts = response.data
      console.log(this.parts);
    });
  },
  methods: {
    viewPart(partId) {
      this.$router.push(`/parts/${partId}`);
    },
    editTest(partId) {
      this.$router.push(`/parts/${partId}`);
    },
    deleteTest(testId) {
      // axios.delete(`${process.env.API_URL}/parts/${partId}`).then(response => {
      //   console.log(response);
      // });
    }
  }
};
</script>