export default {
    setLoggedIn(state, loggedIn) {
        state.loggedIn = loggedIn;
        console.log('state.loggedIn is set to ', loggedIn);
    },
    setAdmin(state, admin) {
        state.admin = admin;
        console.log('state.admin is set to ', admin);
    }
}