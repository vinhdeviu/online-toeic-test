<template>
  <div class="container" v-if="testData.audioLink != null">
    <div class="row">
      <div class="col-sm-2"></div>
      <div class="col-sm-8">
        <audio controls style="width: 100%">
          <source
            :src="testData.audioLink"
            type="audio/mpeg"
          />Your browser does not support the audio element.
        </audio>
      </div>
    </div>
    <keep-alive>
      <part1 :partData="testData.parts['1']" v-if="testProgress==1 && testData.parts['1'] != null"></part1>
      <part2 :partData="testData.parts['2']" v-if="testProgress==2 && testData.parts['2'] != null"></part2>
      <part3 :partData="testData.parts['3']" v-if="testProgress==3 && testData.parts['3'] != null"></part3>
      <part4 :partData="testData.parts['4']" v-if="testProgress==4 && testData.parts['4'] != null"></part4>
      <part5 :partData="testData.parts['5']" v-if="testProgress==5 && testData.parts['5'] != null"></part5>
      <part6 :partData="testData.parts['6']" v-if="testProgress==6 && testData.parts['6'] != null"></part6>
      <part7 :partData="testData.parts['7']" v-if="testProgress==7 && testData.parts['7'] != null"></part7>
    </keep-alive>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";
import Part1 from "../components/part/Part1.vue";
import Part2 from "../components/part/Part2.vue";
import Part3 from "../components/part/Part3.vue";
import Part4 from "../components/part/Part4.vue";
import Part5 from "../components/part/Part5.vue";
import Part6 from "../components/part/Part6.vue";
import Part7 from "../components/part/Part7.vue";

export default {
  components: {
    part1: Part1,
    part2: Part2,
    part3: Part3,
    part4: Part4,
    part5: Part5,
    part6: Part6,
    part7: Part7
  },
  data() {
    return {
      testSubmited: false,
      testData: {}
    };
  },
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn",
      testId: "getTestId",
      testProgress: "getTestProgress",
      testReviewFlag: "getTestReviewFlag"
    })
  },
  created() {
    if (!this.loggedIn) {
      this.$router.push("/login");
    } else {
      this.$store.dispatch("updateTestProgress", 1);
      if(this.testReviewFlag != 0) {
        axios.get(`http://localhost:8081/api/generate-test-achievement/${this.testReviewFlag}`).then(response => {
          this.testData = response.data;
          console.log(this.testData);
          this.$store.dispatch("updateAnswers", []);
          this.$store.dispatch("addAnswersFromQuestions", this.testData.parts['1'].questions);
          this.$store.dispatch("addAnswersFromQuestions", this.testData.parts['2'].questions);
          this.$store.dispatch("addAnswersFromQuestions", this.testData.parts['3'].questions);
          this.$store.dispatch("addAnswersFromQuestions", this.testData.parts['4'].questions);
          this.$store.dispatch("addAnswersFromQuestions", this.testData.parts['5'].questions);
          this.$store.dispatch("addAnswersFromQuestionGroups", this.testData.parts['6'].questionGroups);
          this.$store.dispatch("addAnswersFromQuestionGroups", this.testData.parts['7'].questionGroups);
          this.$store.dispatch("updateSelectedOptions", this.testData.examineeSelectedOptions);
          this.$store.dispatch("updateTestSubmitted", true);
        });
      } else {
        axios.get(`http://localhost:8081/api/generate-test/${this.testId}`).then(response => {
          this.testData = response.data;
          console.log(this.testData);
          this.$store.dispatch("updateAnswers", []);
          this.$store.dispatch("addAnswersFromQuestions", this.testData.parts['1'].questions);
          this.$store.dispatch("addAnswersFromQuestions", this.testData.parts['2'].questions);
          this.$store.dispatch("addAnswersFromQuestions", this.testData.parts['3'].questions);
          this.$store.dispatch("addAnswersFromQuestions", this.testData.parts['4'].questions);
          this.$store.dispatch("addAnswersFromQuestions", this.testData.parts['5'].questions);
          this.$store.dispatch("addAnswersFromQuestionGroups", this.testData.parts['6'].questionGroups);
          this.$store.dispatch("addAnswersFromQuestionGroups", this.testData.parts['7'].questionGroups);
        });
      }
    }
  },
  beforeRouteLeave(to, from, next) {
    if (this.loggedIn) {
      const confirm = window.confirm("Do you really want to leave?");
      if (confirm) {
        this.$store.dispatch("updateTestProgress", 0);
        this.$store.dispatch("updateTestSubmitted", false);
        this.$store.dispatch("updateSelectedOptions", []);
        this.$store.dispatch("updateAnswers", []);
        this.$store.dispatch("updateExamineeAnswers", []);
        this.$store.dispatch("updateTestReviewFlag", 0);
        next();
      } else {
        next(false);
      }
    } else {
      next();
    }
  }
};
</script>