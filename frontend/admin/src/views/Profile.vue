<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <h1>Profile</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12">
        <form v-on:submit.prevent>
          <div class="form-group">
            <label for="email">Email</label>
            <input
              type="text"
              class="form-control"
              id="email"
              name="email"
              placeholder="enter email"
              v-model="admin.email"
              disabled
            />
          </div>
          <div class="form-group">
            <label for="name">Name</label>
            <input
              type="text"
              class="form-control"
              id="name"
              name="name"
              placeholder="enter name"
              v-model="admin.name"
              :disabled="saved"
            />
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input
              type="password"
              class="form-control"
              id="password"
              name="password"
              placeholder="enter password"
              v-model="admin.password"
              :disabled="saved"
            />
          </div>
          <div class="form-group">
            <label for="confirm-password">Confirm Password</label>
            <input
              type="password"
              class="form-control"
              id="confirm-password"
              name="confirm-password"
              placeholder="confirm password"
              v-model="admin.confirmPassword"
              :disabled="saved"
            />
          </div>
          <button v-if="saved" @click="edit()" class="btn btn-primary">Edit</button>
          <button v-if="!saved" @click="save()" class="btn btn-primary">Save</button>
        </form>
      </div>
    </div>
    <hr/>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      admin: null,
      saved: true
    };
  },
  created() {
    this.admin = JSON.parse(localStorage.getItem('admin'));
    this.admin.confirmPassword = this.admin.password;
  },
  methods: {
    edit() {
      this.saved = false;
    },
    save() {
      const API_URL = `${process.env.API_URL}/edit-profile/${this.admin.id}`;
      axios
        .put(API_URL, this.admin)
        .then(response => {
          console.log(response);
          if (response.status == 200) {
            this.saved = true;
            localStorage.setItem('admin', JSON.stringify(this.admin));
            this.$store.dispatch("updateAdmin", Object.assign({}, this.admin));
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
    }
  }
};
</script>