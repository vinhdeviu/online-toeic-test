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
            <label for="testId">Part Id:</label>
            <input
              type="text"
              class="form-control"
              id="testId"
              name="partId"
              v-model="partId"
              disabled
            />
          </div>
          <div class="form-group">
            <label for="index">Group Index:</label>
            <input
              type="number"
              class="form-control"
              id="index"
              name="index"
              placeholder="Enter Index"
              v-model="index"
              :disabled="saved"
            />
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
            <label for="paragraph">Paragraph:</label>
            <textarea
              rows="5"
              class="form-control"
              id="paragraph"
              placeholder="Enter Paragraph"
              name="paragraph"
              v-model="paragraph"
              :disabled="saved"
            ></textarea>
          </div>
          <button v-if="saved" @click="editQuestionGroup()" class="btn btn-primary">Edit</button>
          <button v-if="!saved" @click="saveQuestionGroup()" class="btn btn-primary">Save</button>
        </form>
      </div>
    </div>
    <question
      :testId="testId"
      :partId="partId"
      :groupId="groupId"
      :questions="questions"
    ></question>
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
      index: 0,
      tittle: '',
      imageLink: '',
      paragraph: '',
      questions: [],
      saved: true
    };
  },
  created() {
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
  },
  methods: {
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
        .patch(`${process.env.API_URL}/question-groups//${this.groupId}`, questionGroup)
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
    }
  }
};
</script>