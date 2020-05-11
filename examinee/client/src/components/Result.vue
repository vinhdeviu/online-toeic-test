<template>
  <h1 style="color: #007bff">
    Correct Answer(s) {{correctAnswer}}/{{totalAnswer}}
  </h1>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";

export default {
  props: ['totalAnswer'],
  data() {
    return {
      correctAnswer: 0
    }
  },
  computed: {
    ...mapGetters({
      answers: "getAnswers",
      selectedOptions: "getSelectedOptions",
    })
  },
  created () {
    console.log(this.selectedOptions);
    console.log(this.answers);
    for(let i = 0; i < this.totalAnswer; i++) {
      if(this.selectedOptions[i] != null && this.answers[i].toUpperCase() == this.selectedOptions[i].toUpperCase()) {
        this.correctAnswer++;
      }
    }
    let achievement = {
      examineeId: 1, //temp hard code
      difficulty : 1, //temp hard code
      correctAnswer: this.correctAnswer
    }
    console.log(achievement)
    axios.post("http://localhost:8081/api/achievements", achievement)
    .then(response => {})
    .catch(e => {
      //this.errors.push(e)
    })
  },
  methods: {

  }
};
</script>