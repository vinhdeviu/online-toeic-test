<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <h1>Question Group</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12">
        <form v-on:submit.prevent>
          <div class="form-group" v-if="!isNew">
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
          <div class="form-group" v-if="PART_NEED_QUESTION_GROUP_INDEX.includes(partNum)">
            <label for="index">Group Index:</label>
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
          <div class="form-group">
            <label for="paragraph">Paragraph:</label>
            <textarea
              rows="5"
              class="form-control"
              id="paragraph"
              name="paragraph"
              v-model="paragraph"
              :disabled="!isNew&&saved"
            ></textarea>
          </div>
          <button v-if="!isNew&&saved" @click="editQuestionGroup()" class="btn btn-primary">Edit</button>
          <button v-if="!isNew&&!saved" @click="saveQuestionGroup()" class="btn btn-primary">Save</button>
          <button v-if="isNew" @click="createNewQuestionGroup()" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
    <questions v-if="!isNew"
      :testId="testId"
      :partId="partId"
      :partNum="partNum"
      :groupId="groupId"
      :questions="questions"
    ></questions>
  <hr/>
  <button @click="$router.push(`/tests/${testId}/parts/${partId}`)" class="btn btn-primary btn-sm">Go Back</button>
  </div>
</template>

<script>
import axios from "axios";
import Questions from "../components/Questions.vue";
import {PART_NEED_QUESTION_GROUP_INDEX} from "../const.js";

export default {
  components: {
    questions: Questions
  },
  data() {
    return {
      PART_NEED_QUESTION_GROUP_INDEX: PART_NEED_QUESTION_GROUP_INDEX,
      testId: this.$route.params.testId,
      partId: this.$route.params.partId,
      groupId: this.$route.params.questionGroupId,
      partNum: 0,
      index: null,
      tittle: '',
      imageLink: null,
      paragraph: null,
      questions: [],
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
      });
      if(this.groupId == null) {
        this.isNew = true;
      } else {
        axios
          .get(`${process.env.API_URL}/question-groups/${this.groupId}`)
          .then(response => {
            console.log(response.data);
            this.index = response.data.index;
            this.tittle = response.data.tittle;
            this.imageLink = response.data.imageLink;
            this.paragraph = response.data.paragraph;
          });
        axios
          .get(`${process.env.API_URL}/questions?groupId=${this.groupId}`)
          .then(response => {
            this.questions = response.data;
            console.log(this.questions);
          });
      }

    },
    editQuestionGroup() {
      this.saved = false;
    },
    saveQuestionGroup() {
      let questionGroup = {
        id: this.groupId,
        partId: this.partId,
        index: this.index,
        tittle: this.tittle,
        imageLink: this.imageLink,
        paragraph: this.paragraph
      };
      axios
        .put(`${process.env.API_URL}/question-groups/${this.groupId}`, questionGroup)
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
            alert("Question Group Added");
            let newQuestionGroup = response.data;
            this.saved = true;
            this.isNew = false;
            this.groupId = newQuestionGroup.id;
            this.initData();
            this.$router.push(`/tests/${this.testId}/parts/${this.partId}/question-groups/${this.groupId}`);
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