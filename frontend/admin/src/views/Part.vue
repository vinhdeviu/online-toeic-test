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
    <questions :testId="testId" :partId="partId" :partNum="partNum" :questions="questions" v-if="PARTS_WITHOUT_QUESTION_GROUP.includes(partNum)"></questions>
    <div class="table-wrapper-scroll-y my-custom-scrollbar"
      v-if="!PARTS_WITHOUT_QUESTION_GROUP.includes(partNum) && questionGroups!=null && questionGroups.length>0"
      :style="{height: (questionGroups.length>6?450:35+questionGroups.length*100*0.6) + 'px'}"
    >
      <table class="table table-striped mb-0">
        <thead>
          <tr>
            <th>Question Group Id</th>
            <th v-if="PART_NEED_QUESTION_GROUP_INDEX.includes(partNum)">Group Index</th>
            <th>Tittle</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="questionGroup in questionGroups" :key="questionGroup.id">
            <td>{{questionGroup.id}}</td>
            <td v-if="PART_NEED_QUESTION_GROUP_INDEX.includes(partNum)">{{questionGroup.index}}</td>
            <td>{{questionGroup.tittle}}</td>
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
    <button style="margin-top:10px" v-if="partNum > 5" @click="addNewQuestionGroup()" class="btn btn-primary">Add New Question Group</button>
    <hr/>
    <button @click="$router.push(`/tests/${testId}`)" class="btn btn-primary btn-sm">Go Back</button>
  </div>
</template>

<script>
import axios from "axios";
import Questions from "../components/Questions.vue";
import {PARTS_WITHOUT_QUESTION_GROUP, PART_NEED_QUESTION_GROUP_INDEX} from "../const.js";
import { deleteObjectByIdFromArray } from "../helper";

export default {
  components: {
    "questions": Questions
  },
  data() {
    return {
      PARTS_WITHOUT_QUESTION_GROUP: PARTS_WITHOUT_QUESTION_GROUP,
      PART_NEED_QUESTION_GROUP_INDEX: PART_NEED_QUESTION_GROUP_INDEX,
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
      if (!PARTS_WITHOUT_QUESTION_GROUP.includes(this.partNum)) {
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
        testId: this.testId,
        partNum: this.partNum,
        tittle: this.tittle,
        type: this.type,
        direction: this.direction
      };
      axios
        .put(`${process.env.API_URL}/parts/${this.partId}`, part)
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
          console.log(e.response);
          alert(e.response.data);
          //this.errors.push(e)
        });
    },
    checkQuestionGroup(questionGroupId) {
      this.$router.push(`/tests/${this.testId}/parts/${this.partId}/question-groups/${questionGroupId}`);
    },
    deleteQuestionGroup(questionGroupId) {
      const confirm = window.confirm("Are you sure you want to delete it?");
      if (confirm) {
        axios
          .delete(`${process.env.API_URL}/question-groups/${questionGroupId}`)
          .then(response => {
            console.log(response);
            if (response.status == 204) {
              alert("Question Group deleted successfully");
              deleteObjectByIdFromArray(this.questionGroups, questionGroupId);
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
    addNewQuestionGroup() {
      this.$router.push(`/tests/${this.testId}/parts/${this.partId}/new-question-group`);
    },
    addNewQuestion() {
      this.$router.push(`/tests/${this.testId}/parts/${this.partId}/new-question`);
    }
  }
};
</script>