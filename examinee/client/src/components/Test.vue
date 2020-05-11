<template>
  <div class="col-sm-4">
    <timer :timeInSecond="timeInSecond" v-if="testProgress != 0 && !testSubmitted"></timer>
    <result :totalAnswer="totalAnswer" v-if="testProgress != 0 && testSubmitted"></result>
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
      totalAnswer: 0
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
  beforeCreate() {
    if (this.testProgress != 0) {
      axios.get("http://localhost:8081/api/test-information").then(response => {
        console.log(response.data);
        this.timeInSecond = response.data.timeInSecond;
        this.totalAnswer = response.data.totalAnswer;
      });
    }
  }
};
</script>