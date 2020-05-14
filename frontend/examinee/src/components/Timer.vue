<template>
  <h2>
    {{ timeLeft }}
  </h2>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  props: ['timeInSecond'],
  data() {
    return {
      time: this.timeInSecond,
      timer: null,
    }
  },
  computed: {
    ...mapGetters({
      testSubmitted: "getTestSubmitted"
    }),
    timeLeft() {
      return `${this.minutes}:${this.seconds}`;
    },
    minutes() {
      return String(Math.floor(this.time / 60)).padStart(2, "0");
    },
    seconds() {
      return String(this.time % 60).padStart(2, "0");
    }
  },
  created () {
    this.timer = setInterval(this.decrementOrAlert, 1000)
  },
  methods: {
    decrementOrAlert() {
      if(this.testSubmitted) {
        clearInterval(this.timer);
        return;
      }
      if (this.time > 0) {
        this.time--;
        return;
      }
      alert("Time is up!");
      this.$store.dispatch("updateTestSubmitted", true);
      this.$store.dispatch("updateTestProgress", 1);
      clearInterval(this.timer);
    }
  }
};
</script>