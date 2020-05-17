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
            <th>Question Index</th>
            <th>Tittle</th>
            <th>Image Link</th>
            <th>Correct Answer</th>
            <th>Correct Answer Id</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="question in questions" :key="question.id">
            <td>{{question.id}}</td>
            <td>{{question.index}}</td>
            <td>{{question.questionTittle}}</td>
            <td>{{question.imageLink}}</td>
            <td>{{question.correctAnswer}}</td>
            <td>{{question.correctAnswerId}}</td>
            <td>
              <button @click="checkQuestion(question.id)" class="btn btn-primary btn-sm">Check Detail</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button style="margin-top:10px" @click="addNewQuestion()" class="btn btn-primary">Add New Question</button>
  </div>
</template>

<script>
export default {
  props: ["testId","partId","groupId","questions"],
  methods: {
    checkQuestion(questionId) {
      this.$router.push(`/tests/${this.testId}/parts/${this.partId}/questions/${questionId}`);
    },addNewQuestion(questionId) {
      if(this.groupId == null) {
        this.$router.push(`/tests/${this.testId}/parts/${this.partId}/new-question`);
      } else {
        this.$router.push(`/tests/${this.testId}/parts/${this.partId}/question-groups/${this.groupId}/new-question`);
      }
    },
  }
};
</script>