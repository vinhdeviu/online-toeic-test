<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <button
        class="btn btn-dark d-inline-block d-lg-none ml-auto"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <i class="fas fa-align-justify"></i>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="nav navbar-nav ml-auto">
          <li class="nav-item">
            <a style="cursor:pointer" class="nav-link" @click="logout()">Logout</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>

export default {
  methods: {
    logout() {
      this.$router.push("/login");
      localStorage.removeItem('admin');
      this.$store.dispatch("updateLoggedIn", false);
      this.$store.dispatch("updateAdmin", {});
    }
  }
};
</script>