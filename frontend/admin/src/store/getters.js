export default {
    getLoggedIn: state => state.loggedIn,
    getExamineeId: state => state.examineeId,
    getTestId: state => state.testId,
    getTestProgress: state => state.testProgress,
    getTestReviewFlag: state => state.testReviewFlag,
    getTestSubmitted: state => state.testSubmitted,
    getSelectedOptions: state => state.selectedOptions,
    getAnswers: state => state.answers,
    getExamineeAnswers: state => state.examineeAnswers
}