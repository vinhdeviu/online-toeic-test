<template>
  <!-- Sidebar Holder -->
  <nav id="sidebar">
    <div class="sidebar-header">
      <h3>Dashboard</h3>
    </div>

    <ul class="list-unstyled components">
      <p style="cursor:pointer" onMouseOver="this.style.color='black'" onMouseOut="this.style.color='white'"><b>Nguyen Duy Vinh</b></p>
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
export default {
  methods: {
    toHomePage() {
      this.$router.push("/home");
    },
    toTestsPage() {
      this.$router.push("/tests");
    },
    toExamineesPage() {
      this.$router.push("/examinees");
    }
  }
};
</script>