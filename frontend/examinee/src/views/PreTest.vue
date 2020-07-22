<template>
  <div class="container" style="background-image: url('http://localhost:3000/image/engb.jpg');">
    <div class="row">
      <pre style="font-family: Arial, Helvetica, sans-serif;">
      The TOEIC Listening and Reading test is a valid assessment of English-language reading and listening skills for the workplace. 
      The TOEIC test is a two-hour, paper-and-pencil, multiple-choice test that consists of 200 questions divided into two separately-timed sections:

      Section I: Listening: This section consists of 100 questions and is delivered by audiocassette.
      The Listening section takes approximately 45 minutes.

      Part 1: Photographs 20 items (4-choice)
      Part 2: Question-Response 30 items (3-choice)
      Part 3: Short Conversations 30 items (4-choice)
      Part 4: Short Talks 20 items (4-choice)

      Section II: Reading. The Reading section consists of 100 questions presented in written format in the test booklet. 
      Examinees read a variety of materials and respond at their own pace to questions based on the item content. 
      The Reading section lasts approximately 75 minutes.

      Part 5: Incomplete Sentences 40 items (4-choice)
      Part 6: Error Recognition 20 items (4-choice)
      Part 7: Reading Comprehension 40 items (4-choice)

      Examinees respond to test questions by marking one of the letters (A), (B), (C), or (D) with a pencil on a separate answer sheet. 
      Although the actual testing time is approximately two hours, additional time is needed to allow examinees to complete the biographical questions on the answer sheet 
      and to respond to a brief questionnaire about their educational and work history. 
      Therefore, you should allow approximately 21/2 hours to take the test.
      </pre>
      <div class="col-sm-12 text-center">
        <button @click="doTestNow(testId)" class="btn btn-primary btn-lg">Do Test Now</button>
      </div>
    </div>
    <div style="margin-top:20px"></div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      testId: null
    };
  },
  computed: {
    ...mapGetters({
      loggedIn: "getLoggedIn"
    })
  },
  created() {
    this.testId = this.$route.params.testId;
  },
  methods: {
    doTestNow(testId) {
      console.log("go here")
      if (this.loggedIn) {
        this.$router.push(`/test/${this.testId}`);
      } else {
        alert("please login first");
        this.$router.push("/login");
      }
    }
  },
  watch: {
    $route (to, from){
      this.testId = to.params.testId;
    }
  }
};
</script>