import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from './views/Home.vue';
import Login from './views/Login.vue';
import SignUp from './views/SignUp.vue';
import Profile from './views/Profile.vue';
import Achievement from './views/Achievement.vue';
import Test from './views/Test.vue';

Vue.use(VueRouter);

export default new VueRouter({
    routes: [
        { path: '/', redirect: '/home' },
        { path: '/home', component: Home },
        { path: '/login', component: Login },
        { path: '/sign-up', component: SignUp },
        { path: '/profile', component: Profile },
        { path: '/achievement', component: Achievement },
        { path: '/test/:testId', component: Test }
    ]
});
