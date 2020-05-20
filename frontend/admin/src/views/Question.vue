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
            <label for="questionId">Question Id:</label>
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
          <div class="form-group" v-if="!PARTS_WITHOUT_QUESTION_GROUP.includes(partNum)">
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
          <div class="form-group" v-if="PART_NEED_QUESTION_INDEX.includes(partNum)">
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
          <div class="form-group" v-if="PARTS_WITHOUT_ANSWER_CONTENT.includes(partNum)">
            <label for="type">Correct Answer:</label>
            <select class="form-control" id="type" name="type" v-model="correctAnswer" :disabled="!isNew&&saved">
              <option value="A">A</option>
              <option value="B">B</option>
              <option value="C">C</option>
              <option value="D">D</option>
            </select>
          </div>
          <div class="table-wrapper-scroll-y my-custom-scrollbar" style="height: 300px" v-if="!isNew && !PARTS_WITHOUT_ANSWER_CONTENT.includes(partNum) && answers!=null && answers.length>0">
            <table class="table table-striped mb-0">
              <thead>
                <tr>
                  <th>Option Id</th>
                  <th>Content</th>
                  <th><center>Correct Answer</center></th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="answer in answers" :key="answer.id">
                  <td>{{answer.id}}</td>
                  <td><input type="text" class="form-control" v-model="answer.content" :disabled="saved"/></td>
                  <td><input type="radio" class="form-control" name="correctAnswerId" v-model="correctAnswerId" :value="answer.id" :disabled="saved"/></td>
                </tr>
              </tbody>
            </table>
          </div>
          <button v-if="!isNew&&saved" @click="editQuestion()" class="btn btn-primary">Edit</button>
          <button v-if="!isNew&&!saved" @click="saveQuestion()" class="btn btn-primary">Save</button>
          <button v-if="isNew" @click="createNewQuestion()" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
    <hr/>
    <button v-if="groupId==null" @click="$router.push(`/tests/${testId}/parts/${partId}`)" class="btn btn-primary btn-sm">Go Back</button>
    <button v-if="groupId!=null" @click="$router.push(`/tests/${testId}/parts/${partId}/question-groups/${groupId}`)" class="btn btn-primary btn-sm">Go Back</button>
  </div>
</template>

<script>
import axios from "axios";
import {PARTS_WITHOUT_QUESTION_GROUP, PART_NEED_QUESTION_INDEX, PARTS_WITHOUT_ANSWER_CONTENT} from "../const.js";

export default {
  data() {
    return {
      PARTS_WITHOUT_QUESTION_GROUP: PARTS_WITHOUT_QUESTION_GROUP,
      PART_NEED_QUESTION_INDEX: PART_NEED_QUESTION_INDEX,
      PARTS_WITHOUT_ANSWER_CONTENT: PARTS_WITHOUT_ANSWER_CONTENT,
      partsNeedQuestionIndex: [1,2,3,4,6],
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
    this.initData();
  },
  methods: {
    initData() {
      axios.get(`${process.env.API_URL}/parts/${this.partId}`).then(response => {
        console.log(response.data);
        this.partNum = response.data.partNum;
        if(this.questionId == null) {
          this.isNew = true;
        } else {
          axios.get(`${process.env.API_URL}/questions/${this.questionId}`).then(response => {
            console.log(response.data);
            this.index = response.data.index;
            this.tittle = response.data.questionTittle;
            this.imageLink = response.data.imageLink;
            this.correctAnswer = response.data.correctAnswer;
            this.correctAnswerId = response.data.correctAnswerId;
          });
          if(!PARTS_WITHOUT_ANSWER_CONTENT.includes(this.partNum)) {
            this.initAnswers();
          }
        }
      });
    },
    initAnswers() {
      axios
        .get(`${process.env.API_URL}/answers/?questionId=${this.questionId}`)
        .then(response => {
          this.answers = response.data;
          console.log(this.answers);
        });
    },
    editQuestion() {
      this.saved = false;
    },
    saveQuestion() {
      console.log(this.answers);
      let mapAnswers = this.answers.length>0?{}:null;
      let charOption = ['A','B','C','D'];
      for(let i = 0; i < this.answers.length; i++) {
        mapAnswers[charOption[i]] = this.answers[i];
      }
      console.log(mapAnswers);
      let question = {
        testId: this.testId,
        partId: this.partId,
        groupId: this.groupId,
        questionId: this.questionId,
        index: this.index,
        questionTittle: this.tittle,
        imageLink: this.imageLink,
        correctAnswer: this.correctAnswer,
        correctAnswerId: this.correctAnswerId,
        answers: mapAnswers
      };
      axios
        .put(`${process.env.API_URL}/questions/${this.questionId}`, question)
        .then(response => {
          console.log(response);
          if (response.status == 200) {
            this.saved = true;
            alert("Saved");
            this.initAnswers();
          } else {
            alert("response status not OK from server");
          }
        })
        .catch(e => {
          console.log(e.response);
          alert(e.response.data);
          //this.errors.push(e)
        });
    },
    createNewQuestion() {
      let question = {
        testId: this.testId,
        partId: this.partId,
        groupId: this.groupId,
        questionId: this.questionId,
        index: this.index,
        questionTittle: this.tittle,
        imageLink: this.imageLink,
        correctAnswer: this.correctAnswer,
        correctAnswerId: this.correctAnswerId
      };
      axios
        .post(`${process.env.API_URL}/questions`, question)
        .then(response => {
          console.log(response);
          if(response.status == 201) {
            alert("Question Added");
            let newQuestion = response.data;
            this.saved = true;
            this.isNew = false;
            this.questionId = newQuestion.id;
            this.initData();
            if(this.groupId == null) {
              this.$router.push(`/tests/${this.testId}/parts/${this.partId}/questions/${this.questionId}`);
            } else {
              this.$router.push(`/tests/${this.testId}/parts/${this.partId}/question-groups/${this.groupId}/questions/${this.questionId}`);
            }
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