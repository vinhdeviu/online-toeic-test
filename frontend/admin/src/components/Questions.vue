<template>
  <div>
    <div class="table-wrapper-scroll-y my-custom-scrollbar" 
      v-if="questions!=null && questions.length>0"
      :style="{height: (questions.length>6?450:35+questions.length*100*0.6) + 'px'}"
    >
      <table class="table table-striped mb-0">
        <thead>
          <tr>
            <th>Question Id</th>
            <th v-if="PART_NEED_QUESTION_INDEX.includes(partNum)">Question Index</th>
            <th>Tittle</th>
            <th>Image Link</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="question in questions" :key="question.id">
            <td>{{question.id}}</td>
            <td v-if="PART_NEED_QUESTION_INDEX.includes(partNum)">{{question.index}}</td>
            <td>{{question.questionTittle}}</td>
            <td>{{question.imageLink}}</td>
            <td>
              <button @click="checkQuestion(question.id)" class="btn btn-primary btn-sm">Check Detail</button>
            </td>
            <td>
              <button @click="deleteQuestion(question.id)" class="btn btn-danger btn-sm">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button style="margin-top:10px" @click="addNewQuestion()" class="btn btn-primary">Add New Question</button>
  </div>
</template>

<script>
import {PART_NEED_QUESTION_INDEX} from "../const.js";

export default {
  data() {
    return {
      PART_NEED_QUESTION_INDEX: PART_NEED_QUESTION_INDEX,
    }
  },
  props: ["testId","partNum","partId","groupId","questions"],
  methods: {
    checkQuestion(questionId) {
      if(this.groupId == null) {
        this.$router.push(`/tests/${this.testId}/parts/${this.partId}/questions/${questionId}`);
      } else {
        this.$router.push(`/tests/${this.testId}/parts/${this.partId}/question-groups/${this.groupId}/questions/${questionId}`);
      }
    },
    addNewQuestion(questionId) {
      if(this.groupId == null) {
        this.$router.push(`/tests/${this.testId}/parts/${this.partId}/new-question`);
      } else {
        this.$router.push(`/tests/${this.testId}/parts/${this.partId}/question-groups/${this.groupId}/new-question`);
      }
    },
  }
};
</script>