import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store/global-store';
import { BootstrapVue, IconsPlugin, BCarousel, BCarouselSlide } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false;
Vue.component('b-carousel', BCarousel);
Vue.component('b-carousel-slide', BCarouselSlide);

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