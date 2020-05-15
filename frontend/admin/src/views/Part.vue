<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <h1>Part</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12">
        <form v-on:submit.prevent>
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
            <label for="partNum">Part Number:</label>
            <select class="form-control" id="partNum" name="partNum" v-model="partNum" disabled>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
            </select>
          </div>
          <div class="form-group">
            <label for="type">Type:</label>
            <select class="form-control" id="type" name="type" v-model="type" disabled>
              <option value="1">Listening</option>
              <option value="2">Reading</option>
            </select>
          </div>
          <div class="form-group">
            <label for="tittle">Tittle:</label>
            <input
              type="text"
              class="form-control"
              id="tittle"
              placeholder="Enter Tittle"
              name="tittle"
              v-model="tittle"
              :disabled="saved"
            />
          </div>
          <div class="form-group">
            <label for="direction">Direction:</label>
            <textarea
              rows="3"
              class="form-control"
              id="direction"
              placeholder="Enter Direction"
              name="direction"
              v-model="direction"
              :disabled="saved"
            ></textarea>
          </div>
          <button v-if="saved" @click="editPart()" class="btn btn-primary">Edit</button>
          <button v-if="!saved" @click="savePart()" class="btn btn-primary">Save</button>
        </form>
      </div>
    </div>
    <question :testId="testId" :partId="partId" :questions="questions" v-if="partNum <= 5 && questions!=null"></question>
    <div class="table-wrapper-scroll-y my-custom-scrollbar" v-if="partNum > 5">
      <table class="table table-striped mb-0">
        <thead>
          <tr>
            <th>Question Group Id</th>
            <th v-if="partNum == 6">Group Index</th>
            <th>Tittle</th>
            <th>Image Link</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="questionGroup in questionGroups" :key="questionGroup.id">
            <td>{{questionGroup.id}}</td>
            <td v-if="partNum == 6">{{questionGroup.index}}</td>
            <td>{{questionGroup.tittle}}</td>
            <td>{{questionGroup.imageLink}}</td>
            <td>
              <button
                @click="checkQuestionGroup(questionGroup.id)"
                class="btn btn-primary btn-sm"
              >Check Detail</button>
            </td>
            <td>
              <button
                @click="deleteQuestionGroup(questionGroup.id)"
                class="btn btn-danger btn-sm"
              >Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button  v-if="partNum <= 5" @click="addNewQuestion()" class="btn btn-primary">Add New Question</button>
    <button  v-if="partNum > 5" @click="addNewQuestion()" class="btn btn-primary">Add New Question Group</button>
  </div>
</template>

<script>
import axios from "axios";
import Question from "../components/Question.vue";

export default {
  components: {
    "question": Question
  },
  data() {
    return {
      testId: this.$route.params.testId,
      partId: this.$route.params.partId,
      partNum: 0,
      tittle: "",
      type: 0,
      direction: "",
      questionGroups: [],
      questions: [],
      saved: true
    };
  },
  created() {
    axios.get(`${process.env.API_URL}/parts/${this.partId}`).then(response => {
      console.log(response.data);
      this.partNum = response.data.partNum;
      this.tittle = response.data.tittle;
      this.type = response.data.type;
      this.direction = response.data.direction;
      this.questionGroups = response.data.questionGroups;
      this.questions = response.data.questions;
      if (this.partNum > 5) {
        axios
          .get(`${process.env.API_URL}/question-groups?partId=${this.partId}`)
          .then(response => {
            this.questionGroups = response.data;
            console.log(this.questionGroups);
          });
      } else {
        axios
          .get(`${process.env.API_URL}/questions?partId=${this.partId}`)
          .then(response => {
            this.questions = response.data;
            console.log(this.questions);
          });
      }
    });
  },
  methods: {
    editPart() {
      this.saved = false;
    },
    savePart() {
      let part = {
        id: this.partId,
        partNum: this.partNum,
        tittle: this.tittle,
        type: this.type,
        direction: this.direction
      };
      axios
        .patch(`${process.env.API_URL}/parts/${this.partId}`, part)
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
    checkQuestionGroup(questionGroupId) {
      this.$router.push(`/tests/${this.testId}/parts/${this.partId}/question-groups/${questionGroupId}`);
    }
    // checkQuestions(partId) {
    //   this.$router.push(`/parts/${partId}`);
    // }
  }
};
</script>