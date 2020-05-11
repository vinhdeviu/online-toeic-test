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
      <part2 :partData="testData.parts['2']" :beginIndex="beginIndexPart2" v-if="testProgress==2 && testData.parts['2'] != null"></part2>
      <part3 :partData="testData.parts['3']" :beginIndex="beginIndexPart3" v-if="testProgress==3 && testData.parts['3'] != null"></part3>
      <part4 :partData="testData.parts['4']" :beginIndex="beginIndexPart4" v-if="testProgress==4 && testData.parts['4'] != null"></part4>
      <part5 :partData="testData.parts['5']" :beginIndex="beginIndexPart5" v-if="testProgress==5 && testData.parts['5'] != null"></part5>
      <part6 :partData="testData.parts['6']" :beginIndex="beginIndexPart6" v-if="testProgress==6 && testData.parts['6'] != null"></part6>
      <part7 :partData="testData.parts['7']" :beginIndex="beginIndexPart7" v-if="testProgress==7 && testData.parts['7'] != null"></part7>
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
      testData: {},
      beginIndexPart2: 0,
      beginIndexPart3: 0,
      beginIndexPart4: 0,
      beginIndexPart5: 0,
      beginIndexPart6: 0,
      beginIndexPart7: 0,
    };
  },
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn",
      testProgress: "getTestProgress"
    })
  },
  beforeCreate() {
    axios.get("http://localhost:8081/api/generate-test/1").then(response => {
      this.testData = response.data;
      console.log(this.testData);
      this.beginIndexPart2 = this.testData.parts['1'].questions.length;
      this.beginIndexPart3 = this.beginIndexPart2+this.testData.parts['2'].questions.length;
      this.beginIndexPart4 = this.beginIndexPart3+this.testData.parts['3'].questions.length;
      this.beginIndexPart5 = this.beginIndexPart4+this.testData.parts['4'].questions.length;
      this.beginIndexPart6 = this.beginIndexPart5+this.testData.parts['5'].questions.length;
      let numQuestionPart6 = 0;
      for(let questionGroup of this.testData.parts['6'].questionGroups) {
        for(let question in questionGroup.questions) {
          ++numQuestionPart6;
        }
      }
      this.beginIndexPart7 = this.beginIndexPart6+numQuestionPart6;
    });
  },
  created() {
    if (!this.loggedIn) {
      this.$router.push("/login");
    } else {
      this.$store.dispatch("updateTestProgress", 1);
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