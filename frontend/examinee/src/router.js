import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from './views/Home.vue';
import PreTest from './views/PreTest.vue';
import Login from './views/Login.vue';
import SignUp from './views/SignUp.vue';
import Profile from './views/Profile.vue';
import Achievement from './views/Achievement.vue';
import Test from './views/Test.vue';

Vue.use(VueRouter);

export default new VueRouter({
    scrollBehavior() {
        return { x: 0, y: 0 };
    },
    routes: [
        { path: '/', redirect: '/home' },
        { path: '/home', component: Home },
        { path: '/pre-test/:testId', component: PreTest },
        { path: '/login', component: Login },
        { path: '/sign-up', component: SignUp },
        { path: '/profile', component: Profile },
        { path: '/achievement', component: Achievement },
        { path: '/test/:testId', name: 'test', component: Test },
        { path: '/test/:testId/achievement/:achievementId', name: 'test-achievement', component: Test }
    ]
});
