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
    updateSingleSelectedOption({ commit }, indexAndData) {
        console.log('action updateSingleSelectedOption is processing with indexAndData', indexAndData);
        commit('setSelectedOption', indexAndData);
    },
    addAnswersFromQuestions({ commit }, questions) {
        console.log('action addAnswersFromQuestions is processing with questions', questions);
        let answers = []
        for(let i = 0; i < questions.length; i++) {
            answers[i] = questions[i].correctAnswer;
        }
        commit('mergeAnswers', answers);
    },
    addAnswersFromQuestionGroups({ commit }, questionGroups) {
        console.log('action addAnswersFromQuestionGroups is processing with questionGroups', questionGroups);
        let answers = [];
        let k = 0;
        for(let questionGroup of questionGroups) {
            for(let question of questionGroup.questions) {
                answers[k] = question.correctAnswer;
                k++;
            }
        }
        commit('mergeAnswers', answers);
    },
    updateAnswers({ commit }, answers) {
        console.log('action updateAnswers is processing with answers', answers)
        commit('setAnswers', answers);
    },
    updateExamineeAnswers({ commit }, examineeAnswers) {
        console.log('action updateExamineeAnswers is processing with examineeAnswers', examineeAnswers);
        commit('setExamineeAnswers', examineeAnswers);
    },
    updateSingleExamineeAnswer({ commit }, indexAndData) {
        console.log('action updateSingleExamineeAnswer is processing with indexAndData', indexAndData);
        commit('setExamineeAnswer', indexAndData);
    },
    updatePlayAudioFlag({ commit }, playAudioFlag) {
        console.log('action updatePlayAudioFlag is processing with playAudioFlag', playAudioFlag);
        commit('setPlayAudioFlag', playAudioFlag);
    },
}
// Action doesn't change state so it calls mutation