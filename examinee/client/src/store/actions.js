export default {
    updateLoggedIn({ commit }, loggedIn) {
        console.log('action updateLoggedIn is processing with loggedIn=' + loggedIn)
        commit('setLoggedIn', loggedIn);
    },
    updateTestProgress({ commit }, testProgress) {
        console.log('action updateTestProgress is processing with testProgress=' + testProgress)
        commit('setTestProgress', testProgress);
    }
}