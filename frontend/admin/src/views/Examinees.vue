<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <h1>Examinee Data</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-2">
        <div class="line"></div>
      </div>
      <div class="col-sm-8"></div>
    </div>

    <div class="table-wrapper-scroll-y my-custom-scrollbar"
      :style="{height: (examinees.length>6?450:35+examinees.length*100*0.6) + 'px'}"
      v-if="examinees.length>0"
    >
      <table class="table table-striped mb-0">
        <thead>
          <tr>
            <th>Examinee Id</th>
            <th>Name</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="examinee in examinees" :key="examinee.id">
            <td>{{examinee.id}}</td>
            <td>{{examinee.name}}</td>
            <td>{{examinee.email}}</td>
            <td>
              <button @click="checkExaminee(examinee.id)" class="btn btn-primary btn-sm">Check Detail</button>
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
      examinees: []
    };
  },
  created() {
    axios.get(`${process.env.API_URL}/examinees`).then(response => {
      this.examinees = response.data;
      console.log(this.examinees);
    });
  },
  methods: {
    checkExaminee(examineeId) {
      this.$router.push(`/examinees/${examineeId}`);
    }
  }
};
</script>