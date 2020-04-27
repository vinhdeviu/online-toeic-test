<template>
  <div id="app">
    <page-header></page-header>
    <router-view></router-view>
  </div>
</template>

<script>
import Header from "./components/Header.vue";
export default {
  components: {
    "page-header": Header
  }
};
</script>

<style>
#app {
}
</style>