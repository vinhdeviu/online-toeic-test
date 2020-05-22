export default {
    setLoggedIn(state, loggedIn) {
        state.loggedIn = loggedIn;
        console.log('state.loggedIn is set to ', loggedIn);
    },
    setTestProgress(state, testProgress) {
        state.testProgress = testProgress;
        console.log('state.testProgress is set to ', testProgress);
    },
    setTestSubmitted(state, testSubmitted) {
        state.testSubmitted = testSubmitted;
        console.log('state.testSubmitted is set to ', testSubmitted);
    },
    setSelectedOptions(state, selectedOptions) {
        state.selectedOptions = selectedOptions;
        console.log('state.selectedOptions is set to ', selectedOptions);
    },
    setSelectedOption(state, indexAndData) {
        state.selectedOptions[indexAndData.index] = indexAndData.option;
        console.log('state.selectedOptions is set to ', state.selectedOptions);
    },
    mergeAnswers(state, answers) {
        state.answers = state.answers.concat(answers);
        console.log('state.answers is set to ', state.answers);
    },
    setAnswers(state, answers) {
        state.answers = answers;
        console.log('state.answers is set to ', answers);
    },
    setExamineeAnswer(state, indexAndData) {
        state.examineeAnswers[indexAndData.index] = {
            examineeId: JSON.parse(localStorage.getItem('examinee')).id, 
            questionId: indexAndData.questionId, 
            option: indexAndData.option, 
            answerId: indexAndData.answerId, 
        };
        console.log('state.examineeAnswers is set to ', state.examineeAnswers);
    },
    setExamineeAnswers(state, examineeAnswers) {
        state.examineeAnswers = examineeAnswers;
        console.log('state.examineeAnswers is set to ', examineeAnswers);
    },
    setPlayAudioFlag(state, playAudioFlag) {
        state.playAudioFlag = playAudioFlag;
        console.log('state.playAudioFlag is set to ', playAudioFlag);
    },
}