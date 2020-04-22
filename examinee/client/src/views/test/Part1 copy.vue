<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-2">
        <h5>{{part1Data.part.type == 1?"Listening":"Reading"}}</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-8">
        <h5>{{part1Data.part.tittle}}</h5>{{part1Data.part.direction}}
      </div>
    </div>
    
    <hr />
    <div style="margin-top:30px"></div>
    <div class="row">
      <div class="col-sm-2">
        <h5>Question 1:</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-4">
        <img
          class="img-q1"
          v-bind:src="part1Data.questions[0].imageLink"
          alt="img-q1"
          width="280px"
          height="230px"
        />
        <div style="margin-top:10px"></div>
        <audio controls style="margin-left:-10px">
          <source v-bind:src="part1Data.questions[0].audioLink" type="audio/mpeg" />Your browser does not support the audio element.
        </audio>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q1A" name="q1" class="custom-control-input" />
        <label class="custom-control-label" for="q1A">A</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q1B" name="q1" class="custom-control-input" />
        <label class="custom-control-label" for="q1B">B</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q1C" name="q1" class="custom-control-input" />
        <label class="custom-control-label" for="q1C">C</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q1D" name="q1" class="custom-control-input" />
        <label class="custom-control-label" for="q1D">D</label>
      </div>
    </div>

    <hr />
    <div style="margin-top:30px"></div>
    <div class="row">
      <div class="col-sm-2">
        <h5>Question 2:</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-4">
        <img
          class="img-q1"
          src="https://www.w3schools.com/bootstrap4/paris.jpg"
          alt="img-q1"
          width="280px"
          height="230px"
        />
        <div style="margin-top:10px"></div>
        <audio controls style="margin-left:-10px">
          <source src="https://www.w3schools.com/html/horse.mp3" type="audio/mpeg" />Your browser does not support the audio element.
        </audio>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q2A" name="q2" class="custom-control-input" />
        <label class="custom-control-label" for="q2A">A</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q2B" name="q2" class="custom-control-input" />
        <label class="custom-control-label" for="q2B">B</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q2C" name="q2" class="custom-control-input" />
        <label class="custom-control-label" for="q2C">C</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q2D" name="q2" class="custom-control-input" />
        <label class="custom-control-label" for="q2D">D</label>
      </div>
    </div>

    <hr />
    <div style="margin-top:30px"></div>
    <div class="row">
      <div class="col-sm-2">
        <h5>Question 3:</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-4">
        <img
          class="img-q1"
          src="https://www.w3schools.com/bootstrap4/paris.jpg"
          alt="img-q1"
          width="280px"
          height="230px"
        />
        <div style="margin-top:10px"></div>
        <audio controls style="margin-left:-10px">
          <source src="https://www.w3schools.com/html/horse.mp3" type="audio/mpeg" />Your browser does not support the audio element.
        </audio>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q3A" name="q3" class="custom-control-input" />
        <label class="custom-control-label" for="q3A">A</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q3B" name="q3" class="custom-control-input" />
        <label class="custom-control-label" for="q3B">B</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q3C" name="q3" class="custom-control-input" />
        <label class="custom-control-label" for="q3C">C</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q3D" name="q3" class="custom-control-input" />
        <label class="custom-control-label" for="q3D">D</label>
      </div>
    </div>

    <hr />
    <div style="margin-top:30px"></div>
    <div class="row">
      <div class="col-sm-2">
        <h5>Question 4:</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-4">
        <img
          class="img-q1"
          src="https://www.w3schools.com/bootstrap4/paris.jpg"
          alt="img-q1"
          width="280px"
          height="230px"
        />
        <div style="margin-top:10px"></div>
        <audio controls style="margin-left:-10px">
          <source src="https://www.w3schools.com/html/horse.mp3" type="audio/mpeg" />Your browser does not support the audio element.
        </audio>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q4A" name="q4" class="custom-control-input" />
        <label class="custom-control-label" for="q4A">A</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q4B" name="q4" class="custom-control-input" />
        <label class="custom-control-label" for="q4B">B</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q4C" name="q4" class="custom-control-input" />
        <label class="custom-control-label" for="q4C">C</label>
      </div>
    </div>
    <div class="row">
      <div class="custom-control custom-radio">
        <input type="radio" id="q4D" name="q4" class="custom-control-input" />
        <label class="custom-control-label" for="q4D">D</label>
      </div>
    </div>
    <hr />
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
import { mapGetters } from 'vuex';
import axios from 'axios';

export default {
  data() {
    return {
      part1Data: {
        part: {},
        questions: [
          {},{},{},{}
        ]
      }
    };
  },
  computed: {
    ...mapGetters({
      testProgress: 'getTestProgress'
    })
  },
  mounted () {
    axios
      .get('http://localhost:8081/api/parts/1')
      .then(response => {
        this.part1Data = response.data;
        console.log(this.part1Data);
      })
  },
  methods: {
    nextPart() {
      this.$store.dispatch("updateTestProgress", 2);
    }
  }
};
</script>