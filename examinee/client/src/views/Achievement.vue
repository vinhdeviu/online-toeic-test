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
      <div class="col-sm-4">
        <h3 style="color:#007bff">Date</h3>
        <h4 v-for="(date,index) in dates" :key="'date'+index">{{date}}</h4>
      </div>
      <div class="col-sm-4">
        <h3 style="color:#007bff">Difficulty</h3>
        <h4 v-for="(difficulty,index) in difficulties" :key="'difficulty'+index">{{difficulty}}</h4>
      </div>
      <div class="col-sm-4">
        <h3 style="color:#007bff">Score</h3>
        <h4 v-for="(score,index) in scores" :key="'score'+index">{{score}}</h4>
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
      difficulties: [],
      scores: []
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
      let examinee_id = 1;  // temp hard code
      axios.get(`http://localhost:8081/api/achievements/${examinee_id}`).then(response => {
        console.log(response.data);
        for(let achievement of response.data) {
          this.dates.push(achievement.date);
          this.difficulties.push(achievement.difficulty);
          this.scores.push(achievement.score);
        }
      });
    }
  }
};
</script>