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
          </tr>
        </thead>
        <tbody>
          <tr v-for="question in questions" :key="question.id">
            <td>{{question.id}}</td>
            <td v-if="PART_NEED_QUESTION_INDEX.includes(partNum)">{{question.index}}</td>
            <td>{{question.questionTittle}}</td>
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
import axios from "axios";
import { deleteObjectByIdFromArray } from "../helper";

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
    deleteQuestion(questionId) {
      const confirm = window.confirm("Are you sure you want to delete it?");
      if (confirm) {
        axios
          .delete(`${process.env.API_URL}/questions/${questionId}`)
          .then(response => {
            console.log(response);
            if (response.status == 204) {
              alert("Test deleted successfully");
              deleteObjectByIdFromArray(this.questions, questionId);
            } else {
              alert("response status not OK from server");
            }
          })
          .catch(e => {
            console.log(e);
            console.log(e.response);
            alert(e.response.data);
            //this.errors.push(e)
          });
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