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
    <div v-for="(question, index) in partData.questions" :key="question.id">
      <hr />
      <div style="margin-top:30px"></div>
      <div class="row">
        <div class="col-sm-2">
          <h5>Question {{index+1}}:</h5>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-4">
          <img class="img-q1" :src="question.imageLink" alt="img-q1" width="280px" height="230px" />
          <div style="margin-top:10px"></div>
          <audio controls style="margin-left:-10px">
            <source :src="question.audioLink" type="audio/mpeg" />Your browser does not support the audio element.
          </audio>
        </div>
      </div>
      <div class="row" v-for="option in ['A','B','C','D']" :key="option">
        <div class="custom-control custom-radio">
          <input
            type="radio"
            :id="'q'+(index+1)+option"
            :name="'q'+(index+1)"
            class="custom-control-input"
            :value="option"
            :ref="'q'+(index+1)"
            :disabled="testSubmitted"
            @change="selectOption(index, option)"
          />
          <label class="custom-control-label" :for="'q'+(index+1)+option">{{option}}</label>
          <i v-if="testSubmitted && option.toUpperCase()==question.answer.toUpperCase() && selectedOptions[index]!=null && selectedOptions[index].toUpperCase()==question.answer.toUpperCase()" class="fas fa-check-circle" style="font-size:20px;color:green"></i>
          <i v-if="testSubmitted && option.toUpperCase()==question.answer.toUpperCase() && (selectedOptions[index]== null || selectedOptions[index].toUpperCase()!=question.answer.toUpperCase())" class="fa fa-close" style="font-size:20px;color:red"></i>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <button style="width: 160px;" class="btn btn-primary btn-lg" disabled>Previous</button>
        <button @click="nextPart()" style="width: 160px;" class="btn btn-primary btn-lg">Next</button>
      </div>
    </div>
    <hr />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";
import { myAnswer } from '../../helper/common'

export default {
  data() {
    return {
      partData: {
        part: {},
        questions: [{}, {}, {}, {}]
      }
    };
  },
  computed: {
    ...mapGetters({
      testProgress: "getTestProgress",
      testSubmitted: "getTestSubmitted",
      selectedOptions: "getSelectedOptions",
    })
  },
  mounted() {
    axios.get("http://localhost:8081/api/generate-part/1").then(response => {
      this.partData = response.data;
      console.log(this.partData);
      this.$store.dispatch("addAnswersFromQuestions", this.partData.questions);
    });
  },
  methods: {
    nextPart() {
      this.$store.dispatch("updateTestProgress", 2);
    },
    selectOption(index, option) {
      this.$store.dispatch("updateSingleSelectedOption", {index, option});
    }
  }
};
</script>