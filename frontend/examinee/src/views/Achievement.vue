<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <h2>Achievements</h2>
      </div>
    </div>
    <div style="margin-top:80px"></div>
    <div class="row">
      <div class="col-sm-3">
        <h3 style="color:#007bff">Date</h3>
        <h4 v-for="(date,index) in dates" :key="'date'+index">{{date}}</h4>
      </div>
      <div class="col-sm-3">
        <h3 style="color:#007bff">Test</h3>
        <h4 v-for="(testName,index) in testNames" :key="'testName'+index">{{testName}}</h4>
      </div>
      <div class="col-sm-3">
        <h3 style="color:#007bff">Correct Answer</h3>
        <h4 v-for="(totalCorrectAnswer,index) in totalCorrectAnswers" :key="'totalCorrectAnswer'+index">{{totalCorrectAnswer}}</h4>
      </div>
      <div class="col-sm-3">
        <h3 style="color:#007bff">Detail</h3>
        <div v-for="achievement in achievements" :key="achievement.id">
          <button @click="viewDetail(achievement)" class="btn btn-primary btn-sm">View</button>
          <div style="margin-top:8px"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";

export default {
  data() {
    return {
      dates: [],
      testNames: [],
      totalCorrectAnswers: [],
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
        for(let achievement of this.achievements) {
          this.dates.push(achievement.date);
          this.testNames.push(achievement.testName);
          this.totalCorrectAnswers.push(achievement.totalCorrectAnswer);
        }
      });
    }
  },
  methods: {
    viewDetail(achievement) {
      console.log(achievement);
      this.$store.dispatch("updateTestReviewFlag", achievement.id);
      this.$router.push(`/test/${achievement.testId}`);
    },
  }
};
</script>