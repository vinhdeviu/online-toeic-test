<template>
  <!-- Sidebar Holder -->
  <nav id="sidebar">
    <div class="sidebar-header">
      <h3>Dashboard</h3>
    </div>

    <ul class="list-unstyled components">
      <p style="cursor:pointer" @click="toProfilePage()" onMouseOver="this.style.color='black'" onMouseOut="this.style.color='white'" v-if="admin!=null"><b>{{admin.name}}</b></p>
      <li>
        <a style="cursor:pointer" @click="toHomePage()">Home</a>
      </li>
      <li>
        <a style="cursor:pointer" @click="toTestsPage()">Test Data</a>
      </li>
      <li>
        <a style="cursor:pointer" @click="toExamineesPage()">Examinee Data</a>
      </li>
    </ul>
  </nav>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    ...mapGetters({
      admin: "getAdmin"
    })
  },
  created() {
    let admin = JSON.parse(localStorage.getItem('admin'));
    this.$store.dispatch("updateAdmin", admin);
  },
  methods: {
    toHomePage() {
      this.$router.push("/home");
    },
    toTestsPage() {
      this.$router.push("/tests");
    },
    toExamineesPage() {
      this.$router.push("/examinees");
    },
    toProfilePage() {
      this.$router.push("/profile");
    }
  }
};
</script>