<template>
  <element>
    <hr />
    <div style="margin-top:30px"></div>
    <div class="row">
      <div class="col-sm-12">
        <h5>Question {{question.questionNo}}: {{question.questionTittle}}</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-4">
        <img v-if="question.imageLink!==null && question.imageLink!==''" class="img" :src="question.imageLink" alt="img" width="280px" height="230px" />
        <div style="margin-top:10px"></div>
      </div>
    </div>
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
          @change="selectOption(question, option)"
          :checked="selectedOptions[question.questionNo-1]!=null && option.toUpperCase()==selectedOptions[question.questionNo-1].toUpperCase()"
        />
        <label class="custom-control-label" :for="'q'+(question.questionNo)+option">{{option}}. <span v-if="question.answers!=null && question.answers[option]!=null && question.answers[option].content!=null">{{question.answers[option].content}}</span></label>
        <i v-if="testSubmitted && option.toUpperCase()==question.correctAnswer.toUpperCase() && selectedOptions[question.questionNo-1]!=null && selectedOptions[question.questionNo-1].toUpperCase()==question.correctAnswer.toUpperCase()" class="fas fa-check-circle" style="font-size:20px;color:green"></i>
        <i v-if="testSubmitted && option.toUpperCase()==question.correctAnswer.toUpperCase() && (selectedOptions[question.questionNo-1]== null || selectedOptions[question.questionNo-1].toUpperCase()!=question.correctAnswer.toUpperCase())" class="fa fa-close" style="font-size:20px;color:red"></i>
      </div>
    </div>
  </element>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";

export default {
  props: ['question'],
  computed: {
    ...mapGetters({
      testSubmitted: "getTestSubmitted",
      selectedOptions: "getSelectedOptions",
    })
  },
  methods: {
    selectOption(question, option) {
      let index = question.questionNo-1;
      let questionId = question.id;
      let answerId = null;
      if(question.answers!=null && question.answers[option]!=null && question.answers[option].id!=0) {
        answerId = question.answers[option].id;
      }
      this.$store.dispatch("updateSingleSelectedOption", {index, option});
      this.$store.dispatch("updateSingleExamineeAnswer", {index, option, questionId, answerId});
    }
  }
};
</script>