export default {
    updateLoggedIn({ commit }, loggedIn) {
        console.log('action updateLoggedIn is processing with loggedIn', loggedIn)
        commit('setLoggedIn', loggedIn);
    },
    updateTestProgress({ commit }, testProgress) {
        console.log('action updateTestProgress is processing with testProgress', testProgress);
        commit('setTestProgress', testProgress);
    },
    updateTestSubmitted({ commit }, testSubmitted) {
        console.log('action updateTestSubmitted is processing with testSubmitted', testSubmitted);
        commit('setTestSubmitted', testSubmitted);
    },
    updateSelectedOptions({ commit }, selectedOptions) {
        console.log('action updateSelectedOptions is processing with selectedOptions', selectedOptions);
        commit('setSelectedOptions', selectedOptions);
    },
    updateSingleSelectedOption({ commit }, indexAndOption) {
        console.log('action updateSingleSelectedOption is processing with indexAndOption', indexAndOption);
        commit('setSelectedOption', indexAndOption);
    },
    addAnswersFromQuestions({ commit }, questions) {
        console.log('action addAnswersFromQuestions is processing with questions', questions);
        let answers = []
        for(let i = 0; i < questions.length; i++) {
            answers[i] = questions[i].answer;
        }
        commit('mergeAnswers', answers);
    },
    addAnswersFromQuestionGroups({ commit }, questionGroups) {
        console.log('action addAnswersFromQuestionGroups is processing with questionGroups', questionGroups);
        let answers = [];
        let k = 0;
        for(let questionGroup of questionGroups) {
            for(let question of questionGroup.questions) {
                answers[k] = question.answer;
                k++;
            }
        }
        commit('mergeAnswers', answers);
    },
    updateAnswers({ commit }, answers) {
        console.log('action updateAnswers is processing with answers', answers)
        commit('setAnswers', answers);
    },
}