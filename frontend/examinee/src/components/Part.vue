<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-2">
        <h5>{{partData.type == 1?"Listening":"Reading"}}</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-8">
        <h5>{{partData.tittle}}</h5>
        {{partData.direction}}
      </div>
    </div>
    <div v-for="question in partData.questions" :key="question.id">
      <question :question="question"></question>
    </div>
    <div v-for="(questionGroup, indexGroup) in partData.questionGroups" :key="questionGroup.id">
      <div style="margin-top:30px"></div>
      <div class="row">
        <div class="col-sm-12">
          <h4>Paragraph No.{{(indexGroup+1)}}:</h4>
          <div  v-if="questionGroup.paragraph!=undefined&&questionGroup.paragraph!==null&&questionGroup.paragraph!==''" style="white-space: pre-line">{{questionGroup.paragraph}}</div>
          <img v-if="questionGroup.imageLink!=undefined&&questionGroup.imageLink!==null&&questionGroup.imageLink!==''" class="img" :src="questionGroup.imageLink" alt="img" width="500px" height="500px" />
        </div>
      </div>
      <div v-for="question in questionGroup.questions" :key="question.id">
        <question style="margin-left:20px" :question="question"></question>
      </div>
      <hr />
    </div>
    <div class="row" style="margin-top:20px">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <button @click="prevPart()" style="width: 160px;" class="btn btn-primary btn-lg" :disabled="part==1">Previous</button>
        <button @click="nextPart()" style="width: 160px;" class="btn btn-primary btn-lg" v-if="part!=7">Next</button>
        <button v-if="part==7 && !testSubmitted" @click="submitTest()" style="width: 160px;" class="btn btn-primary btn-lg">Submit</button>
        <button v-if="part==7 && testSubmitted" @click="retest()" style="width: 160px;" class="btn btn-primary btn-lg">Retest</button>
      </div>
    </div>
    <hr />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Question from "./Question.vue";

export default {
  components: {
    question: Question,
  },
  computed: {
    ...mapGetters({
      testSubmitted: "getTestSubmitted"  //use getter to get state
    })
  },
  props: ['part', 'partData'],//get part and partData from Test
  methods: {
    prevPart() {
      this.$store.dispatch("updatePlayAudioFlag", false);
      this.$store.dispatch("updateTestProgress", this.part-1);
      window.scrollTo(0,0);
    },
    nextPart() {
      this.$store.dispatch("updatePlayAudioFlag", false);
      this.$store.dispatch("updateTestProgress", this.part+1);
      window.scrollTo(0,0);
    },
    submitTest() {
      this.$store.dispatch("updateTestSubmitted", true);
      this.$store.dispatch("updateTestProgress", 1);
      let audio = document.getElementById("listeningAudio");// get the audio and pause 
      audio.pause();
      audio.currentTime = 0;
      window.scrollTo(0,0);
    },
    retest() {
      this.$router.push("/home");
    }
  }
};
</script>