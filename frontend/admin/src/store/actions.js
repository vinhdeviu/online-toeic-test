export default {
    updateLoggedIn({ commit }, loggedIn) {
        console.log('action updateLoggedIn is processing with loggedIn', loggedIn)
        commit('setLoggedIn', loggedIn);
    },
    updateAdmin({ commit }, admin) {
        console.log('action updateAdmin is processing with admin', admin)
        commit('setAdmin', admin);
    }
}