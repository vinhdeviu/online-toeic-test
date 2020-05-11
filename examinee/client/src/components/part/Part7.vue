<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-2">
        <h5>{{partData.type == 1?"Listening":"Reading"}}</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-8">
        <h5>{{partData.tittle}}</h5>
        {{partData.direction}}
      </div>
    </div>

    <hr />
    <div
      v-for="(questionGroup, indexGroup) in partData.questionGroups"
      :key="questionGroup.id"
    >
      <div style="margin-top:30px"></div>
      <div class="row">
        <div class="col-sm-12">
          <h4>Paragraph No.{{(indexGroup+1)}}:</h4>
          <div>{{questionGroup.paragraph}}</div>
        </div>
      </div>
      <hr/>
      <div
        class="row"
        v-for="(question, indexQuestion) in questionGroup.questions"
        :key="question.id"
      >
        <div class="col-sm-8">
          <h5>Question {{increaseQuestionCounter()}}: {{question.questionTittle}}</h5>
          <div class="row" v-for="option in ['A','B','C','D']" :key="option">
            <div class="custom-control custom-radio">
              <input
                type="radio"
                :id="'q'+(indexQuestion+(questionGroup.questions.length*indexGroup)+beginIndex+1)+option"
                :name="'q'+(indexQuestion+(questionGroup.questions.length*indexGroup)+beginIndex+1)"
                class="custom-control-input"
                :value="option"
                :ref="'q'+(indexQuestion+(questionGroup.questions.length*indexGroup)+beginIndex+1)"
                :disabled="testSubmitted"
                @change="selectOption(indexQuestion+(questionGroup.questions.length*indexGroup)+beginIndex, option)"
              />
              <label
                class="custom-control-label"
                :for="'q'+(indexQuestion+(questionGroup.questions.length*indexGroup)+beginIndex+1)+option"
              >{{option}}. {{question.answers[option].content}}</label>
              <i
                v-if="testSubmitted && option.toUpperCase()==question.correctAnswer.toUpperCase() && selectedOptions[indexQuestion+(questionGroup.questions.length*indexGroup)+beginIndex]!=null && selectedOptions[indexQuestion+(questionGroup.questions.length*indexGroup)+beginIndex].toUpperCase()==question.correctAnswer.toUpperCase()"
                class="fas fa-check-circle"
                style="font-size:20px;color:green"
              ></i>
              <i
                v-if="testSubmitted && option.toUpperCase()==question.correctAnswer.toUpperCase() && (selectedOptions[indexQuestion+(questionGroup.questions.length*indexGroup)+beginIndex]== null || selectedOptions[indexQuestion+(questionGroup.questions.length*indexGroup)+beginIndex].toUpperCase()!=question.correctAnswer.toUpperCase())"
                class="fa fa-close"
                style="font-size:20px;color:red"
              ></i>
            </div>
          </div>
        </div>
      </div>
      <hr />
    </div>
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <button @click="prevPart()" style="width: 160px;" class="btn btn-primary btn-lg">Previous</button>
        <button v-if="!testSubmitted" @click="submitTest()" style="width: 160px;" class="btn btn-primary btn-lg">Submit</button>
        <button v-if="testSubmitted" @click="retest()" style="width: 160px;" class="btn btn-primary btn-lg">Retest</button>
      </div>
    </div>
    <hr />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";

export default {
  props: ['partData', 'beginIndex'],
  data() {
    return {
      // partData: {
      //   part: {},
      //   questionGroupOutputList: [
      //     {
      //       questionGroup: {},
      //       questions: [{}, {}, {}]
      //     },
      //     {
      //       questionGroup: {},
      //       questions: [{}, {}, {}]
      //     }
      //   ]
      // },
      // beginIndex: 1
      questionCounter: this.beginIndex
    };
  },
  computed: {
    ...mapGetters({
      testSubmitted: "getTestSubmitted",
      answers: "getAnswers",
      selectedOptions: "getSelectedOptions"
    })
  },
  beforeUpdate() { 
    this.questionCounter = this.beginIndex 
  },
  mounted() {
    // axios.get("http://localhost:8081/api/generate-part/7").then(response => {
    //   this.partData = response.data;
    //   console.log(this.partData);
    //   this.beginIndex = this.answers.length;
    //   this.$store.dispatch(
    //     "addAnswersFromQuestionGroups",
    //     this.partData.questionGroupOutputList
    //   );
    // });
    console.log(this.partData);
  },
  methods: {
    prevPart() {
      this.$store.dispatch("updateTestProgress", 6);
    },
    submitTest() {
      this.$store.dispatch("updateTestSubmitted", true);
      this.$store.dispatch("updateTestProgress", 1);
    },
    selectOption(index, option) {
      this.$store.dispatch("updateSingleSelectedOption", { index, option });
    },
    retest() {
      this.$router.push("/home");
    },
    increaseQuestionCounter() {
      this.questionCounter++;
      return this.questionCounter + '';
    }
  }
};
</script>