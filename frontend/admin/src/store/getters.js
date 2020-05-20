export default {
    getLoggedIn: state => {
        if(state.loggedIn) {
            return true;
        }
        let admin = JSON.parse(localStorage.getItem('admin'));
        if(admin != null) {
            return true;
        }
    },
    getAdmin: state => state.admin
}