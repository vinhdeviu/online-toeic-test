<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <h1>Examinee</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12">
        <form v-on:submit.prevent>
          <div class="form-group">
            <label for="id">Examinee Id:</label>
            <input
              type="text"
              class="form-control"
              id="id"
              name="id"
              :value="examinee.id"
              disabled
            />
          </div>
          <div class="form-group">
            <label for="name">Name:</label>
            <input
              type="text"
              class="form-control"
              id="name"
              name="name"
              :value="examinee.name"
              disabled
            />
          </div>
          <div class="form-group">
            <label for="email">Email:</label>
            <input
              type="text"
              class="form-control"
              id="email"
              name="email"
              :value="examinee.email"
              disabled
            />
          </div>
        </form>
      </div>
    </div>
    <div class="table-wrapper-scroll-y my-custom-scrollbar"
      v-if="achievements.length>0"
      :style="{height: (achievements.length>6?450:35+achievements.length*100*0.6) + 'px'}"
    >
      <table class="table table-striped mb-0">
        <thead>
          <tr>
            <th>Achievement Id</th>
            <th>Date</th>
            <th>Test Id</th>
            <th>Total Correct Answer</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="achievement in achievements" :key="achievement.id">
            <td>{{achievement.id}}</td>
            <td>{{achievement.date}}</td>
            <td>{{achievement.testId}}</td>
            <td>{{achievement.totalCorrectAnswer}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <hr/>
    <button @click="$router.push(`/examinees`)" class="btn btn-primary btn-sm">Go Back</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      examineeId: this.$route.params.examineeId,
      examinee: {},
      achievements: []
    };
  },
  created() {
    axios.get(`${process.env.API_URL}/users/${this.examineeId}`).then(response => {
      this.examinee = response.data;
      console.log(this.examinee);
    });
    axios.get(`${process.env.API_URL}/achievements?examineeId=${this.examineeId}`).then(response => {
      this.achievements = response.data;
      console.log(this.achievements);
    });
  }
};
</script>