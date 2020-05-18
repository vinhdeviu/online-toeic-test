<template>
  <div class="col-sm-4">
    <timer :timeInSecond="timeInSecond" v-if="!testSubmitted && timeInSecond != 0"></timer>
    <result :totalQuestions="totalQuestions" v-if="testSubmitted && totalQuestions != 0"></result>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";
import Timer from "./Timer.vue";
import Result from "./Result.vue";

export default {
  data() {
    return {
      timeInSecond: 0,
      totalQuestions: 0
    };
  },
  components: {
    timer: Timer,
    result: Result
  },
  computed: {
    ...mapGetters({
      testProgress: "getTestProgress",
      testSubmitted: "getTestSubmitted"
    })
  },
  watch: {
    $route (to, from){
      let testId = to.params.testId;
      if (testId != null) {
        axios.get(`${process.env.API_URL}/test-information/${testId}`).then(response => {
          console.log(response.data);
          this.timeInSecond = response.data.timeInSecond;
          this.totalQuestions = response.data.totalQuestions;
        });
      } else {
        this.timeInSecond = 0;
        this.totalQuestions = 0;
      }
    }
  }
};
</script>