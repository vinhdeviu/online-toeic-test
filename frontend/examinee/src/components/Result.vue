<template>
  <h1 style="color: #007bff">Correct Answer(s) {{totalCorrectAnswer}}/{{totalQuestions}}</h1>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";

export default {
  props: ["totalQuestions"],
  data() {
    return {
      totalCorrectAnswer: 0
    };
  },
  computed: {
    ...mapGetters({
      answers: "getAnswers",
      selectedOptions: "getSelectedOptions",
      examineeAnswers: "getExamineeAnswers"
    })
  },
  created() {
    console.log(this.selectedOptions);
    console.log(this.answers);
    console.log(this.examineeAnswers);
    for (let i = 0; i < this.totalQuestions; i++) {
      if (
        this.selectedOptions[i] != null &&
        this.answers[i].toUpperCase() == this.selectedOptions[i].toUpperCase()
      ) {
        this.totalCorrectAnswer++;
      }
    }
    if (this.$route.params.achievementId == null) {
      let achievement = {
        examineeId: JSON.parse(localStorage.getItem('examinee')).id,
        testId: this.$route.params.testId,
        totalCorrectAnswer: this.totalCorrectAnswer,
        examineeAnswers: this.examineeAnswers
      };
      console.log(achievement);
      console.log(JSON.stringify(achievement));
      axios
        .post(`${process.env.API_URL}/achievements`, achievement)
        .then(response => {console.log(response);})
        .catch(e => {
          //this.errors.push(e)
        });
    }
    // If test post achievement 
  },
  methods: {}
};
</script>