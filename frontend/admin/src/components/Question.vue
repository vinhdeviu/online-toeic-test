<template>
  <div class="table-wrapper-scroll-y my-custom-scrollbar">
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
</template>

<script>
export default {
  props: ["testId","partId","questions"],
  methods: {
    checkQuestion(questionId) {
      this.$router.push(`/tests/${testId}/parts/${partId}/questions/${questionId}`);
    },
  }
};
</script>