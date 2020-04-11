export default {
    setLoggedIn(state, loggedIn) {
        state.loggedIn = loggedIn;
        console.log('state.loggedIn is set to ' + loggedIn);
    },
    setTestProgress(state, testProgress) {
        state.testProgress = testProgress;
        console.log('state.testProgress is set to ' + testProgress);
    }
}