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
    setSelectedOption(state, indexAndOption) {
        state.selectedOptions[indexAndOption.index] = indexAndOption.option;
        console.log('state.selectedOptions is set to ', state.selectedOptions);
    },
    mergeAnswers(state, answers) {
        state.answers = state.answers.concat(answers);
        console.log('state.answers is set to ', state.answers);
    },
    setAnswers(state, answers) {
        state.answers = answers;
        console.log('state.answers is set to ', answers);
    }
}