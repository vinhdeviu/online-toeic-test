<template>
  <div class="container">
    <div>
      <b-carousel
        id="carousel-1"
        v-model="slide"
        :interval="2000"
        controls
        indicators
        background="#ababab"
        img-width="1024"
        img-height="480"
        style="text-shadow: 1px 1px 2px #333;"
        @sliding-start="onSlideStart"
        @sliding-end="onSlideEnd"
      >
        <b-carousel-slide
          caption="English for tommorow"
          text="Learning english for your future."
          img-src="http://localhost:3000/image/eng1.jpg"
        ></b-carousel-slide>
        <b-carousel-slide
          caption="English for yesterday"
          text="You are better than yourself yesterday."
          img-src="http://localhost:3000/image/eng2.jpg"
        ></b-carousel-slide>
        <b-carousel-slide
          caption="English for today"
          text="Learning english now."
          img-src="http://localhost:3000/image/eng3.jpg"
        ></b-carousel-slide>
      </b-carousel>
    </div>
    <div style="margin-top:10px"></div>
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <h2>Take A TOEIC Mock Test</h2>
      </div>
    </div>
    <div style="margin-top:10px"></div>
    <div class="row" v-for="testChunk in testChunks" :key="testChunk.id">
      <div class="col-sm-4" v-for="test in testChunk" :key="test.id">
        <button @click="doTest(test.id)" class="btn btn-primary btn-block">{{test.testName}}</button>
        <div style="margin-top:20px"></div>
      </div>
    </div>
  </div>
</template>

<script>
import _ from "lodash";
import axios from "axios";
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      tests: [],
      slide: 0,
      sliding: null
    };
  },
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn"
    }),
    testChunks() {
      return _.chunk(Object.values(this.tests), 3);
    }
  },
  created() {
    axios.get(`${process.env.API_URL}/tests`).then(response => {
      this.tests = response.data;
      console.log(this.tests);
    });
  },
  methods: {
    doTest(testId) {
      if (this.loggedIn) {
        this.$router.push(`/pre-test/${testId}`);
      } else {
        alert("please login first");
        this.$router.push("/login");
      }
    },
    onSlideStart(slide) {
      this.sliding = true;
    },
    onSlideEnd(slide) {
      this.sliding = false;
    }
  }
};
</script>