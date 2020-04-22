<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-2">
        <h5>{{part1Data.part.type == 1?"Listening":"Reading"}}</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-8">
        <h5>{{part1Data.part.tittle}}</h5>
        {{part1Data.part.direction}}
      </div>
    </div>
    <div v-for="(question, index) in part1Data.questions" :key="question.id">
      <hr />
      <div style="margin-top:30px"></div>
      <div class="row">
        <div class="col-sm-2">
          <h5>Question {{index+1}}:</h5>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-4">
          <img
            class="img-q1"
            v-bind:src="question.imageLink"
            alt="img-q1"
            width="280px"
            height="230px"
          />
          <div style="margin-top:10px"></div>
          <audio controls style="margin-left:-10px">
            <source v-bind:src="question.audioLink" type="audio/mpeg" />Your browser does not support the audio element.
          </audio>
        </div>
      </div>
      <div class="row" v-for="option in ['A','B','C','D']" :key="option">
        <div class="custom-control custom-radio">
          <input
            type="radio"
            v-bind:id="'q'+(index+1)+option"
            v-bind:name="'q'+(index+1)"
            class="custom-control-input"
          />
          <label class="custom-control-label" v-bind:for="'q'+(index+1)+option">{{option}}</label>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <button style="width: 160px;" class="btn btn-primary btn-lg" disabled>Previous</button>
        <button @click="nextPart()" style="width: 160px;" class="btn btn-primary btn-lg">Next</button>
      </div>
    </div>
    <hr />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";

export default {
  data() {
    return {
      part1Data: {
        part: {},
        questions: [{}, {}, {}, {}]
      }
    };
  },
  computed: {
    ...mapGetters({
      testProgress: "getTestProgress"
    })
  },
  mounted() {
    axios.get("http://localhost:8081/api/parts/1").then(response => {
      this.part1Data = response.data;
      console.log(this.part1Data);
    });
  },
  methods: {
    nextPart() {
      this.$store.dispatch("updateTestProgress", 2);
    }
  }
};
</script>