<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <h2>Achievements</h2>
      </div>
    </div>
    <div style="margin-top:80px"></div>
    <div class="table-wrapper-scroll-y my-custom-scrollbar"
      v-if="achievements.length>0"
      :style="{height: (achievements.length>6?450:35+achievements.length*100*0.6) + 'px'}"
    >
      <table class="table table-striped mb-0">
        <thead>
          <tr>
            <th>Date</th>
            <th>Test Id</th>
            <th>Total Correct Answer</th>
            <th>Detail</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="achievement in achievements" :key="achievement.id">
            <td>{{achievement.date}}</td>
            <td>{{achievement.testId}}</td>
            <td>{{achievement.totalCorrectAnswer}}</td>
            <td><button @click="viewDetail(achievement)" class="btn btn-primary btn-sm">View</button></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";

export default {
  data() {
    return {
      achievements: []
    };
  },
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn"
    })
  },
  created() {
    if (!this.loggedIn) {
      this.$router.push("/login");
    } else {
      axios.get(`${process.env.API_URL}/achievements/?examineeId=${JSON.parse(localStorage.getItem('examinee')).id}`).then(response => {
        console.log(response.data);
        this.achievements = response.data;
      });
    }
  },
  methods: {
    viewDetail(achievement) {
      console.log(achievement);
      this.$router.push(`/test/${achievement.testId}/achievement/${achievement.id}`);
    },
  }
};
</script>