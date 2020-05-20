import Vue from 'vue';
import App from './App.vue';
import VueResource from 'vue-resource';
import router from './router';
import store from './store/global-store';
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './static/css/style.css'

Vue.config.productionTip = false;

Vue.use(VueResource);

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App),
});

// Install BootstrapVue
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)