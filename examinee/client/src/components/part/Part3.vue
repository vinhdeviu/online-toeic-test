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
        <div class="col-sm-2">
          <h5>Dialog {{indexGroup+1}}:</h5>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-4">
          <div style="margin-top:10px"></div>
          <audio controls style="margin-left:-10px">
            <source :src="questionGroupOutput.questionGroup.audioLink" type="audio/mpeg" />Your browser does not support the audio element.
          </audio>
        </div>
      </div>
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
        <button @click="nextPart()" style="width: 160px;" class="btn btn-primary btn-lg">Next</button>
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
    axios.get("http://localhost:8081/api/generate-part/3").then(response => {
      this.partData = response.data;
      console.log(this.partData);
      this.beginIndex = this.answers.length;
      this.$store.dispatch("addAnswersFromQuestionGroups", this.partData.questionGroupOutputList);
    });
  },
  methods: {
    prevPart() {
      this.$store.dispatch("updateTestProgress", 2);
    },
    nextPart() {
      this.$store.dispatch("updateTestProgress", 4);
    },
    selectOption(index, option) {
      this.$store.dispatch("updateSingleSelectedOption", { index, option });
    }
  }
};
</script>