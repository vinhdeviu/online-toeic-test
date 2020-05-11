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
    <div v-for="(question, index) in partData.questions" :key="question.id">
      <hr />
      <div style="margin-top:30px"></div>
      <div class="row">
        <div class="col-sm-2">
          <h5>Question {{index+beginIndex+1}}:</h5>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-4">
          <div style="margin-top:10px"></div>
        </div>
      </div>
      <div class="row" v-for="option in ['A','B','C','D']" :key="option">
        <div class="custom-control custom-radio">
          <input
            type="radio"
            :id="'q'+(index+beginIndex+1)+option"
            :name="'q'+(index+beginIndex+1)"
            class="custom-control-input"
            :value="option"
            :ref="'q'+(index+beginIndex+1)"
            :disabled="testSubmitted"
            @change="selectOption(index+beginIndex, option)"
          />
          <label class="custom-control-label" :for="'q'+(index+beginIndex+1)+option">{{option}}. {{question.answers[option].content}}</label>
          <i
            v-if="testSubmitted && option.toUpperCase()==question.answer.toUpperCase() && selectedOptions[index+beginIndex]!=null && selectedOptions[index+beginIndex].toUpperCase()==question.answer.toUpperCase()"
            class="fas fa-check-circle"
            style="font-size:20px;color:green"
          ></i>
          <i
            v-if="testSubmitted && option.toUpperCase()==question.answer.toUpperCase() && (selectedOptions[index+beginIndex]== null || selectedOptions[index+beginIndex].toUpperCase()!=question.answer.toUpperCase())"
            class="fa fa-close"
            style="font-size:20px;color:red"
          ></i>
        </div>
      </div>
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
    // axios.get("http://localhost:8081/api/generate-part/4").then(response => {
    //   this.partData = response.data;
    //   console.log(this.partData);
    //   this.beginIndex = this.answers.length;
    //   this.$store.dispatch("addAnswersFromQuestionGroups", this.partData.questionGroupOutputList);
    // });
    console.log(this.partData);
  },
  methods: {
    prevPart() {
      this.$store.dispatch("updateTestProgress", 3);
    },
    nextPart() {
      this.$store.dispatch("updateTestProgress", 5);
    },
    selectOption(index, option) {
      this.$store.dispatch("updateSingleSelectedOption", { index, option });
    }
  }
};
</script>