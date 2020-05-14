import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from './views/Home.vue';
import Tests from './views/Tests.vue';
import Test from './views/Test.vue';
//import Part from './views/Part.vue';
import Examinees from './views/Examinees.vue';

Vue.use(VueRouter);

export default new VueRouter({
    routes: [
        { path: '/', redirect: '/home' },
        { path: '/home', component: Home },
        { path: '/tests', component: Tests },
        { path: '/tests/:testId', component: Test },
        //{ path: '/parts/:partId', component: Part },
        { path: '/examinees', component: Examinees }
    ]
});
