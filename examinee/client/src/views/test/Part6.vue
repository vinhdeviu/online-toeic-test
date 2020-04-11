<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-2">
        <h5>Reading</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-8">
        <h5>Part 6: Text Completion</h5>Read the texts that follow. A word or phrase
        is missing in some of the sentences. Four answer
        choices are given below each of the sentences. Select
        the best answer to complete the text. Then mark the
        letter (A), (B), (C), or (D) on your answer sheet.
      </div>
    </div>
    <div style="margin-top:20px"></div>
    <div class="row">
      <div class="col-sm-12">
        <h5>Question 27-30:</h5>
        <div>
          Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet ______(27) kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,______(28) diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet ______(29) gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
          Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam ______(30). At vero eos et accusam et justo duo dolores
        </div>
      </div>
    </div>
    <hr />
    <div style="margin-top:30px"></div>
    <div class="row">
      <div class="col-sm-8">
        <h5>Question 27</h5>
        <div class="custom-control custom-radio">
          <input type="radio" id="q27A" name="q27" class="custom-control-input" />
          <label class="custom-control-label" for="q27A">A. Cat</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q27B" name="q27" class="custom-control-input" />
          <label class="custom-control-label" for="q27B">B. Dog</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q27C" name="q27" class="custom-control-input" />
          <label class="custom-control-label" for="q27C">C. Cow</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q27D" name="q27" class="custom-control-input" />
          <label class="custom-control-label" for="q27D">D. Bird</label>
        </div>
      </div>
    </div>
    <hr />
    <div class="row">
      <div class="col-sm-8">
        <h5>Question 28</h5>
        <div class="custom-control custom-radio">
          <input type="radio" id="q28A" name="q28" class="custom-control-input" />
          <label class="custom-control-label" for="q28A">A. Cat</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q28B" name="q28" class="custom-control-input" />
          <label class="custom-control-label" for="q28B">B. Dog</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q28C" name="q28" class="custom-control-input" />
          <label class="custom-control-label" for="q28C">C. Cow</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q28D" name="q28" class="custom-control-input" />
          <label class="custom-control-label" for="q28D">D. Bird</label>
        </div>
      </div>
    </div>
    <hr />
    <div class="row">
      <div class="col-sm-8">
        <h5>Question 29</h5>
        <div class="custom-control custom-radio">
          <input type="radio" id="q29A" name="q29" class="custom-control-input" />
          <label class="custom-control-label" for="q29A">A. Cat</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q29B" name="q29" class="custom-control-input" />
          <label class="custom-control-label" for="q29B">B. Dog</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q29C" name="q29" class="custom-control-input" />
          <label class="custom-control-label" for="q29C">C. Cow</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q29D" name="q29" class="custom-control-input" />
          <label class="custom-control-label" for="q29D">D. Bird</label>
        </div>
      </div>
    </div>
    <hr />
    <div class="row">
      <div class="col-sm-8">
        <h5>Question 30</h5>
        <div class="custom-control custom-radio">
          <input type="radio" id="q30A" name="q30" class="custom-control-input" />
          <label class="custom-control-label" for="q30A">A. Cat</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q30B" name="q30" class="custom-control-input" />
          <label class="custom-control-label" for="q30B">B. Dog</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q30C" name="q30" class="custom-control-input" />
          <label class="custom-control-label" for="q30C">C. Cow</label>
        </div>
        <div class="custom-control custom-radio">
          <input type="radio" id="q30D" name="q30" class="custom-control-input" />
          <label class="custom-control-label" for="q30D">D. Bird</label>
        </div>
      </div>
    </div>
    <hr />
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <button @click="prevPart()" style="width: 160px;" class="btn btn-primary btn-lg">Previous</button>
        <button @click="nextPart()" style="width: 160px;" class="btn btn-primary btn-lg">Next</button>
      </div>
    </div>
    <hr />
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters({
      testProgress: 'getTestProgress'
    })
  },
  methods: {
    prevPart() {
      this.$store.dispatch("updateTestProgress", 5);
    },
    nextPart() {
      this.$store.dispatch("updateTestProgress", 7);
    }
  }
}
</script>