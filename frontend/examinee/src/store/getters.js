export default {
    getLoggedIn: state => {
        if(state.loggedIn) {
            return true;
        }
        let examinee = JSON.parse(localStorage.getItem('examinee'));
        if(examinee != null) {
            return true;
        }
        //check login by localStorage, if it is not null loggedIn is true.
    },
    getTestProgress: state => state.testProgress,
    getTestSubmitted: state => state.testSubmitted,
    getSelectedOptions: state => state.selectedOptions,
    getAnswers: state => state.answers,
    getExamineeAnswers: state => state.examineeAnswers,
    getPlayAudioFlag: state => state.playAudioFlag,
}