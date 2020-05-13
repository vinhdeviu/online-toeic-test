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
          <div style="white-space: pre-line">{{questionGroup.paragraph}}</div>
        </div>
      </div>
      <hr/>
      <div
        class="row"
        v-for="question in questionGroup.questions"
        :key="question.id"
      >
        <div class="col-sm-8">
          <h5>Question {{question.questionNo}}: {{question.questionTittle}}</h5>
          <div class="row" v-for="option in ['A','B','C','D']" :key="option">
            <div class="custom-control custom-radio">
              <input
                type="radio"
                :id="'q'+(question.questionNo)+option"
                :name="'q'+(question.questionNo)"
                class="custom-control-input"
                :value="option"
                :ref="'q'+(question.questionNo)"
                :disabled="testSubmitted"
                @change="selectOption(question.questionNo-1, option, question.id, question.answers[option].id)"
                :checked="selectedOptions[question.questionNo-1]!=null && option.toUpperCase()==selectedOptions[question.questionNo-1].toUpperCase()"
              />
              <label class="custom-control-label" :for="'q'+(question.questionNo)+option">{{option}}. {{question.answers[option].content}}</label>
              <i v-if="testSubmitted && option.toUpperCase()==question.correctAnswer.toUpperCase() && selectedOptions[question.questionNo-1]!=null && selectedOptions[question.questionNo-1].toUpperCase()==question.correctAnswer.toUpperCase()" class="fas fa-check-circle" style="font-size:20px;color:green"></i>
              <i v-if="testSubmitted && option.toUpperCase()==question.correctAnswer.toUpperCase() && (selectedOptions[question.questionNo-1]== null || selectedOptions[question.questionNo-1].toUpperCase()!=question.correctAnswer.toUpperCase())" class="fa fa-close" style="font-size:20px;color:red"></i>
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
  props: ['partData'],
  computed: {
    ...mapGetters({
      testSubmitted: "getTestSubmitted",
      answers: "getAnswers",
      selectedOptions: "getSelectedOptions"
    })
  },
  methods: {
    prevPart() {
      this.$store.dispatch("updateTestProgress", 5);
      window.scrollTo(0,0);
    },
    nextPart() {
      this.$store.dispatch("updateTestProgress", 7);
      window.scrollTo(0,0);
    },
    selectOption(index, option, questionId, answerId) {
      this.$store.dispatch("updateSingleSelectedOption", {index, option});
      this.$store.dispatch("updateSingleExamineeAnswer", {index, option, questionId, answerId});
    }
  }
};
</script>