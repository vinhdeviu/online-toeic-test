import Vue from 'vue';
import VueRouter from 'vue-router';
import Login from './views/Login.vue';
import Home from './views/Home.vue';
import Profile from './views/Profile.vue';
import Tests from './views/Tests.vue';
import Test from './views/Test.vue';
import Part from './views/Part.vue';
import QuestionGroup from './views/QuestionGroup.vue';
import Question from './views/Question.vue';
import Examinees from './views/Examinees.vue';
import Examinee from './views/Examinee.vue';

Vue.use(VueRouter);

export default new VueRouter({
    scrollBehavior() {
        return { x: 0, y: 0 };
    },
    routes: [
        { path: '/', redirect: '/login' },
        { path: '/login', name: 'login', component: Login },
        { path: '/home', component: Home },
        { path: '/profile', component: Profile },
        { path: '/tests', component: Tests },
        { path: '/new-test', component: Test },
        { path: '/tests/:testId', component: Test },
        { path: '/tests/:testId/parts/:partId', component: Part },
        { path: '/tests/:testId/parts/:partId/new-question-group', component: QuestionGroup },
        { path: '/tests/:testId/parts/:partId/new-question', component: Question },
        { path: '/tests/:testId/parts/:partId/question-groups/:questionGroupId', component: QuestionGroup },
        { path: '/tests/:testId/parts/:partId/question-groups/:questionGroupId/new-question', component: Question },
        { path: '/tests/:testId/parts/:partId/questions/:questionId', component: Question },
        { path: '/tests/:testId/parts/:partId/question-groups/:questionGroupId/questions/:questionId', component: Question },
        { path: '/examinees', component: Examinees },
        { path: '/examinees/:examineeId', component: Examinee }
    ]
});
