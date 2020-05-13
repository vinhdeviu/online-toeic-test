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
        <div v-for="achievementId in achievementIds" :key="achievementId">
          <button @click="viewDetail(achievementId)" class="btn btn-primary btn-sm">View</button>
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
      achievementIds: []
    };
  },
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn",
      examineeId: "getExamineeId"
    })
  },
  created() {
    if (!this.loggedIn) {
      this.$router.push("/login");
    } else {
      let examinee_id = 1;  // temp hard code
      axios.get(`http://localhost:8081/api/achievements/?examineeId=${this.examineeId}`).then(response => {
        console.log(response.data);
        for(let achievement of response.data) {
          this.dates.push(achievement.date);
          this.testNames.push(achievement.testName);
          this.totalCorrectAnswers.push(achievement.totalCorrectAnswer);
          this.achievementIds.push(achievement.id);
        }
      });
    }
  },
  methods: {
    viewDetail(achievementId) {
      console.log(achievementId);
      this.$store.dispatch("updateTestReviewFlag", achievementId);
      this.$router.push("/test");
    },
  }
};
</script>