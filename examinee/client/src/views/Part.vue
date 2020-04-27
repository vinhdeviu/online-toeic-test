<template>
  <keep-alive>
    <part1 v-if="this.testProgress==1"></part1>
    <part2 v-if="this.testProgress==2"></part2>
    <part3 v-if="this.testProgress==3"></part3>
    <part4 v-if="this.testProgress==4"></part4>
    <part5 v-if="this.testProgress==5"></part5>
    <part6 v-if="this.testProgress==6"></part6>
    <part7 v-if="this.testProgress==7"></part7>
  </keep-alive>
</template>

<script>
import { mapGetters } from "vuex";
import Part1 from "../components/part/Part1.vue";
import Part2 from "../components/part/Part2.vue";
import Part3 from "../components/part/Part3.vue";
import Part4 from "../components/part/Part4.vue";
import Part5 from "../components/part/Part5.vue";
import Part6 from "../components/part/Part6.vue";
import Part7 from "../components/part/Part7.vue";

export default {
  components: {
    part1: Part1,
    part2: Part2,
    part3: Part3,
    part4: Part4,
    part5: Part5,
    part6: Part6,
    part7: Part7
  },
  data() {
    return {
      testSubmited: false
    };
  },
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn",
      testProgress: "getTestProgress"
    })
  },
  created() {
    if (!this.loggedIn) {
      this.$router.push("/login");
    } else {
      this.$store.dispatch("updateTestProgress", 1);
    }
  },
  beforeRouteLeave(to, from, next) {
    if (this.loggedIn) {
      const confirm = window.confirm(
        "Do you really want to leave?"
      );
      if (confirm) {
        this.$store.dispatch("updateTestProgress", 0);
        this.$store.dispatch("updateTestSubmitted", false);
        this.$store.dispatch("updateSelectedOptions", []);
        this.$store.dispatch("updateAnswers", []);
        next();
      } else {
        next(false);
      }
    } else {
      next();
    }
  }
};
</script>