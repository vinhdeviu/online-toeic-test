export default {
    getLoggedIn: state => {
        if(state.loggedIn) {
            return true;
        }
        let examinee = JSON.parse(localStorage.getItem('examinee'));
        if(examinee != null) {
            return true;
        }
    },
    getTestProgress: state => state.testProgress,
    getTestSubmitted: state => state.testSubmitted,
    getSelectedOptions: state => state.selectedOptions,
    getAnswers: state => state.answers,
    getExamineeAnswers: state => state.examineeAnswers,
    getPlayAudioFlag: state => state.playAudioFlag,
}