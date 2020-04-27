<template>
  <h1 style="color: #007bff">
    Correct Answer(s) {{score}}/{{totalScore}}
  </h1>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";

export default {
  props: ['totalScore'],
  data() {
    return {
      score: 0
    }
  },
  computed: {
    ...mapGetters({
      answers: "getAnswers",
      selectedOptions: "getSelectedOptions",
    })
  },
  created () {
    for(let i = 0; i < this.totalScore; i++) {
      if(this.selectedOptions[i] != null && this.answers[i].toUpperCase() == this.selectedOptions[i].toUpperCase()) {
        this.score++;
      }
    }
    let achievement = {
      examineeId: 1, //temp hard code
      difficulty : 1, //temp hard code
      score: this.score
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