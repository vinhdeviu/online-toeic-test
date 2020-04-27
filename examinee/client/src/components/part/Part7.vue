<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-2">
        <h5>{{partData.part.type == 1?"Listening":"Reading"}}</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-8">
        <h5>{{partData.part.tittle}}</h5>
        {{partData.part.direction}}
      </div>
    </div>

    <hr />
    <div
      v-for="(questionGroupOutput, indexGroup) in partData.questionGroupOutputList"
      :key="questionGroupOutput.questionGroup.id"
    >
      <div style="margin-top:30px"></div>
      <div class="row">
        <div class="col-sm-12">
          <h5>Question {{beginIndex+(questionGroupOutput.questions.length)*indexGroup+1}}-{{beginIndex+(questionGroupOutput.questions.length)*indexGroup+(questionGroupOutput.questions.length)}}:</h5>
          <div>{{questionGroupOutput.questionGroup.paragraph}}</div>
        </div>
      </div>
      <hr />
      <div
        class="row"
        v-for="(question, indexQuestion) in questionGroupOutput.questions"
        :key="question.id"
      >
        <div class="col-sm-8">
          <h5>Question {{indexQuestion+(questionGroupOutput.questions.length*indexGroup)+beginIndex+1}}: {{question.questionTittle}}</h5>
          <div class="row" v-for="option in ['A','B','C','D']" :key="option">
            <div class="custom-control custom-radio">
              <input
                type="radio"
                :id="'q'+(indexQuestion+(questionGroupOutput.questions.length*indexGroup)+beginIndex+1)+option"
                :name="'q'+(indexQuestion+(questionGroupOutput.questions.length*indexGroup)+beginIndex+1)"
                class="custom-control-input"
                :value="option"
                :ref="'q'+(indexQuestion+(questionGroupOutput.questions.length*indexGroup)+beginIndex+1)"
                :disabled="testSubmitted"
                @change="selectOption(indexQuestion+(questionGroupOutput.questions.length*indexGroup)+beginIndex, option)"
              />
              <label
                class="custom-control-label"
                :for="'q'+(indexQuestion+(questionGroupOutput.questions.length*indexGroup)+beginIndex+1)+option"
              >{{option}}. {{question['option'+option]}}</label>
              <i
                v-if="testSubmitted && option.toUpperCase()==question.answer.toUpperCase() && selectedOptions[indexQuestion+(questionGroupOutput.questions.length*indexGroup)+beginIndex]!=null && selectedOptions[indexQuestion+(questionGroupOutput.questions.length*indexGroup)+beginIndex].toUpperCase()==question.answer.toUpperCase()"
                class="fas fa-check-circle"
                style="font-size:20px;color:green"
              ></i>
              <i
                v-if="testSubmitted && option.toUpperCase()==question.answer.toUpperCase() && (selectedOptions[indexQuestion+(questionGroupOutput.questions.length*indexGroup)+beginIndex]== null || selectedOptions[indexQuestion+(questionGroupOutput.questions.length*indexGroup)+beginIndex].toUpperCase()!=question.answer.toUpperCase())"
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
  data() {
    return {
      partData: {
        part: {},
        questionGroupOutputList: [
          {
            questionGroup: {},
            questions: [{}, {}, {}]
          },
          {
            questionGroup: {},
            questions: [{}, {}, {}]
          }
        ]
      },
      beginIndex: 1
    };
  },
  computed: {
    ...mapGetters({
      testSubmitted: "getTestSubmitted",
      answers: "getAnswers",
      selectedOptions: "getSelectedOptions"
    })
  },
  mounted() {
    axios.get("http://localhost:8081/api/generate-part/7").then(response => {
      this.partData = response.data;
      console.log(this.partData);
      this.beginIndex = this.answers.length;
      this.$store.dispatch(
        "addAnswersFromQuestionGroups",
        this.partData.questionGroupOutputList
      );
    });
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
    }
  }
};
</script>