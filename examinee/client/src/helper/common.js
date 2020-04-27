export const myAnswer = function(question) {
    let myAnswerField = document.querySelector(`input[name=${question}]:checked`);
    if(typeof myAnswerField === 'undefined ' || myAnswerField === null) {
        return '';
    }
    if(typeof myAnswerField.value === 'undefined ' || myAnswerField.value === null) {
        return '';
    }
    return myAnswerField.value;
}
