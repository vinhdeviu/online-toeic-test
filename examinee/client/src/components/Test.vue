<template>
  <div class="col-sm-4">
    <timer :timeInSecond="timeInSecond" v-if="testProgress != 0 && !testSubmitted"></timer>
    <score :totalScore="totalScore" v-if="testProgress != 0 && testSubmitted"></score>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";
import Timer from "./Timer.vue";
import Score from "./Score.vue";

export default {
  data() {
    return {
      timeInSecond: 0,
      totalScore: 0
    };
  },
  components: {
    timer: Timer,
    score: Score
  },
  computed: {
    ...mapGetters({
      testProgress: "getTestProgress",
      testSubmitted: "getTestSubmitted"
    })
  },
  beforeCreate() {
    if (this.testProgress != 0) {
      axios.get("http://localhost:8081/api/test-information").then(response => {
        console.log(response.data);
        this.timeInSecond = response.data.timeInSecond;
        this.totalScore = response.data.totalScore;
      });
    }
  }
};
</script>