<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <h1>Test</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12">
        <form v-on:submit.prevent>
          <div class="form-group">
            <label for="testId">Test Id:</label>
            <input
              type="text"
              class="form-control"
              id="testId"
              name="testId"
              v-model="testId"
              disabled
            />
          </div>
          <div class="form-group">
            <label for="testName">Test Name:</label>
            <input
              type="text"
              class="form-control"
              id="testName"
              placeholder="Enter Name"
              name="testName"
              v-model="testName"
              :disabled="saved"
            />
          </div>
          <div class="form-group">
            <label for="audioLink">Audio Link:</label>
            <input
              type="text"
              class="form-control"
              id="audioLink"
              placeholder="Enter Audio Link"
              name="audioLink"
              v-model="audioLink"
              :disabled="saved"
            />
          </div>
          <button v-if="saved" @click="editTest()" class="btn btn-primary">Edit</button>
          <button v-if="!saved" @click="saveTest()" class="btn btn-primary">Save</button>
        </form>
      </div>
    </div>

    <div class="table-wrapper-scroll-y my-custom-scrollbar">
      <table class="table table-striped mb-0">
        <thead>
          <tr>
            <th>Part Id</th>
            <th>Part Number</th>
            <th>Tittle</th>
            <th>Type</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="part in parts" :key="part.id">
            <td>{{part.id}}</td>
            <td>{{part.partNum}}</td>
            <td>{{part.tittle}}</td>
            <td>{{part.type==1?"Listening":"Reading"}}</td>
            <td>
              <button @click="checkPart(part.id)" class="btn btn-primary btn-sm">Check Detail</button>
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
      testName: "",
      audioLink: "",
      parts: [],
      saved: true
    };
  },
  created() {
    axios.get(`${process.env.API_URL}/tests/${this.testId}`).then(response => {
      console.log(response);
      this.testName = response.data.testName;
      this.audioLink = response.data.audioLink;
    });
    axios.get(`${process.env.API_URL}/parts?testId=${this.testId}`).then(response => {
      this.parts = response.data;
      console.log(this.parts);
    });
  },
  methods: {
    editTest() {
      this.saved = false;
    },
    saveTest() {
      let test = {
        id: this.testId,
        testName: this.testName,
        audioLink: this.audioLink
      }
      axios
        .patch(`${process.env.API_URL}/tests/${this.testId}`, test)
        .then(response => {
          console.log(response);
          if(response.status == 200) {
            this.saved = true;
            alert("Saved");
          } else {
            alert("response status not OK from server");
          }
        })
        .catch(e => {
          //this.errors.push(e)
      });
    },
    checkPart(partId) {
      this.$router.push(`/tests/${this.testId}/parts/${partId}`);
    }
  }
};
</script>