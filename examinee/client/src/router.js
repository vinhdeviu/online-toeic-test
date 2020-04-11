import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from './views/common/Home.vue';
import Login from './views/common/Login.vue';
import SignUp from './views/common/SignUp.vue';
import Profile from './views/common/Profile.vue';
import Archivement from './views/common/Archivement.vue';
import Test from './views/common/Test.vue';

Vue.use(VueRouter);

export default new VueRouter({
    routes: [
        { path: '/', redirect: '/home' },
        { path: '/home', component: Home },
        { path: '/login', component: Login },
        { path: '/sign-up', component: SignUp },
        { path: '/profile', component: Profile },
        { path: '/archivement', component: Archivement },
        { path: '/test', component: Test }
    ]
});
