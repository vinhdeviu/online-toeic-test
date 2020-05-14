<template>
  <!-- Sidebar Holder -->
  <nav id="sidebar">
    <div class="sidebar-header">
      <h3>Dashboard</h3>
    </div>

    <ul class="list-unstyled components">
      <p>Nguyen Duy Vinh</p>
      <li>
        <a @click="toHomePage()">Home</a>
      </li>
      <li class="active">
        <a
          href="#pageSubmenu"
          data-toggle="collapse"
          aria-expanded="false"
          class="dropdown-toggle"
        >Test Data</a>
        <ul class="collapse list-unstyled" id="pageSubmenu">
          <li>
            <a @click="toTestsPage()">Manage Tests</a>
          </li>
          <li>
            <a>Add New Test</a>
          </li>
        </ul>
      </li>
      <li>
        <a @click="toExamineesPage()">Examinee Data</a>
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