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
          <div v-if="!isNew" class="form-group">
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
              name="testName"
              v-model="testName"
              :disabled="!isNew&&saved"
            />
          </div>
          <div class="form-group">
            <label for="audioLink">Audio Link:</label>
            <input
              type="text"
              class="form-control"
              id="audioLink"
              name="audioLink"
              v-model="audioLink"
              :disabled="!isNew&&saved"
            />
          </div>
          <button v-if="!isNew&&saved" @click="editTest()" class="btn btn-primary">Edit</button>
          <button v-if="!isNew&&!saved" @click="saveTest()" class="btn btn-primary">Save</button>
          <button v-if="isNew" @click="createNewTest()" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>

    <div v-if="!isNew" class="table-wrapper-scroll-y my-custom-scrollbar">
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
    <hr/>
    <button @click="$router.push(`/tests`)" class="btn btn-primary btn-sm">Go Back</button>
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
      saved: true,
      isNew: false
    };
  },
  created() {
    this.initData();
  },
  methods: {
    initData() {
      if(this.testId == null) {
        this.isNew = true;
      } else {
        axios.get(`${process.env.API_URL}/tests/${this.testId}`).then(response => {
          console.log(response);
          this.testName = response.data.testName;
          this.audioLink = response.data.audioLink;
        });
        axios.get(`${process.env.API_URL}/parts?testId=${this.testId}`).then(response => {
          this.parts = response.data;
          console.log(this.parts);
        });
      }
    },
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
        .put(`${process.env.API_URL}/tests/${this.testId}`, test)
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
          console.log(e.response);
          alert(e.response.data);
          //this.errors.push(e)
      });
    },
    checkPart(partId) {
      this.$router.push(`/tests/${this.testId}/parts/${partId}`);
    },
    createNewTest() {
      let test = {
        testName: this.testName,
        audioLink: this.audioLink
      }
      axios
        .post(`${process.env.API_URL}/tests`, test)
        .then(response => {
          if(response.status == 201) {
            alert("Test Added");
            let newtest = response.data;
            this.saved = true;
            this.isNew = false;
            this.testId = newtest.id;
            this.initData();
            this.$router.push(`/tests/${this.testId}`);
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