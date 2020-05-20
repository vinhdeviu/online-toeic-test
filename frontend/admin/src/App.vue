<template>
  <div id="app">
    <router-view v-if="$route.name === 'login'"></router-view>
    <div class="wrapper" v-if="$route.name !== 'login'">
      <side-bar></side-bar>
      <div id="content">
        <page-header></page-header>
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import SideBar from "./components/SideBar.vue";
import Header from "./components/Header.vue";

export default {
  components: {
    "side-bar": SideBar,
    "page-header": Header
  }
};
</script>

<style>
#app {
}
</style>