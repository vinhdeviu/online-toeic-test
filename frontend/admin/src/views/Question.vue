<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <h1>Question</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12">
        <form v-on:submit.prevent>
          <div class="form-group" v-if="!isNew">
            <label for="groupId">Question Id:</label>
            <input
              type="text"
              class="form-control"
              id="questionId"
              name="questionId"
              v-model="questionId"
              disabled
            />
          </div>
          <div class="form-group">
            <label for="testId">Test Id:</label>
            <input
              type="text"
              class="form-control"
              id="testId"
              name="testId"
              v-model="testId"
              disabled
            />
          </div>
          <div class="form-group">
            <label for="partId">Part Id:</label>
            <input
              type="text"
              class="form-control"
              id="partId"
              name="partId"
              v-model="partId"
              disabled
            />
          </div>
          <div class="form-group">
            <label for="groupId">Group Id:</label>
            <input
              type="text"
              class="form-control"
              id="groupId"
              name="groupId"
              v-model="groupId"
              disabled
            />
          </div>
          <div class="form-group" v-if="partNum == 6">
            <label for="index">Question Index:</label>
            <input
              type="number"
              class="form-control"
              id="index"
              name="index"
              v-model="index"
              :disabled="!isNew&&saved"
            />
          </div>
          <div class="form-group">
            <label for="tittle">Tittle:</label>
            <input
              type="text"
              class="form-control"
              id="tittle"
              name="tittle"
              v-model="tittle"
              :disabled="!isNew&&saved"
            />
          </div>
          <div class="form-group">
            <label for="imageLink">Image Link:</label>
            <input
              type="text"
              class="form-control"
              id="imageLink"
              name="imageLink"
              v-model="imageLink"
              :disabled="!isNew&&saved"
            />
          </div>
          <div class="table-wrapper-scroll-y my-custom-scrollbar" style="height: 300px" v-if="!isNew && answers!=null && answers.length>0">
            <table class="table table-striped mb-0">
              <thead>
                <tr>
                  <th>Option Id</th>
                  <th>Content</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="answer in answers" :key="answer.id">
                  <td>{{answer.id}}</td>
                  <td><input type="text" class="form-control" :value="answer.content" :disabled="saved"/></td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="form-group">
            <label for="type">Correct Answer:</label>
            <select class="form-control" id="type" name="type" v-model="correctAnswer" :disabled="saved" v-if="!isNew && answers!=null && answers.length>0">
              <option value="A">A</option>
              <option value="B">B</option>
              <option value="C">C</option>
              <option value="D">D</option>
            </select>
          </div>
          <button v-if="!isNew&&saved" @click="editQuestion()" class="btn btn-primary">Edit</button>
          <button v-if="!isNew&&!saved" @click="saveQuestion()" class="btn btn-primary">Save</button>
          <button v-if="isNew" @click="createNewQuestion()" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Question from "../components/Question.vue";

export default {
  components: {
    question: Question
  },
  data() {
    return {
      testId: this.$route.params.testId,
      partId: this.$route.params.partId,
      groupId: this.$route.params.questionGroupId,
      questionId: this.$route.params.questionId,
      partNum: 0,
      index: null,
      tittle: '',
      imageLink: null,
      correctAnswer: null,
      correctAnswerId: null,
      answers: [],
      saved: true,
      isNew: false
    };
  },
  created() {
    axios.get(`${process.env.API_URL}/parts/${this.partId}`).then(response => {
      console.log(response.data);
      this.partNum = response.data.partNum;
    });
    if(this.questionId == null) {
      this.isNew = true;
      return;
    }
    axios.get(`${process.env.API_URL}/questions/${this.questionId}`).then(response => {
      console.log(response.data);
      this.index = response.data.index;
      this.tittle = response.data.questionTittle;
      this.imageLink = response.data.imageLink;
      this.correctAnswer = response.data.correctAnswer;
      this.correctAnswerId = response.data.correctAnswerId;
    });
    if(this.partNum <= 2) {
      axios
        .get(`${process.env.API_URL}/answers/?questionId=${this.questionId}`)
        .then(response => {
          this.answers = response.data;
          console.log(this.answers);
        });
    }
  },
  methods: {
    editQuestion() {
      this.saved = false;
    },
    saveQuestion() {
      let question = {
        id: this.groupId,
        partId: this.partId,
        index: this.index,
        tittle: this.tittle,
        imageLink: this.imageLink,
        paragraph: this.paragraph
      };
      axios
        .patch(`${process.env.API_URL}/question-groups/${this.groupId}`, questionGroup)
        .then(response => {
          console.log(response);
          if (response.status == 200) {
            this.saved = true;
            alert("Saved");
          } else {
            alert("response status not OK from server");
          }
        })
        .catch(e => {
          //this.errors.push(e)
        });
    },
    createNewQuestionGroup() {
      let questionGroup = {
        partId: this.partId,
        index: this.index,
        tittle: this.tittle,
        imageLink: this.imageLink,
        paragraph: this.paragraph
      };
      axios
        .post(`${process.env.API_URL}/question-groups`, questionGroup)
        .then(response => {
          console.log(response);
          if(response.status == 201) {
            this.saved = true;
            alert("Question Group Added");
            this.$router.push(`/tests/${this.testId}/parts/${this.partId}`);
          } else {
            alert("response status not OK from server");
          }
        })
        .catch(e => {
          console.log(e.response);
          alert(e.response.data);
          //this.errors.push(e)
      });
    }
  }
};
</script>