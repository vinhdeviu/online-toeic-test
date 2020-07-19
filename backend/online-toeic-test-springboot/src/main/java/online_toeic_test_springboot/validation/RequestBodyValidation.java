package online_toeic_test_springboot.validation;

import online_toeic_test_springboot.domain.model.*;
import online_toeic_test_springboot.exception.BadRequestBodyException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class RequestBodyValidation {

    public void validateAchievement(Achievement achievement, HttpMethod httpMethod) {
        System.out.println(achievement);
        StringBuilder badRequestBodyErrorMessage = new StringBuilder();
        if(httpMethod == HttpMethod.PUT) {
            if(achievement.getId() == null || achievement.getId() <= 0) {
                badRequestBodyErrorMessage.append("id is required. ");
            }
        }
        if(achievement.getExamineeId() == null || achievement.getExamineeId() <= 0) {
            badRequestBodyErrorMessage.append("examineeId is required. ");
        }
        if(achievement.getTestId() == null || achievement.getTestId() <= 0) {
            badRequestBodyErrorMessage.append("testId is required. ");
        }
        if(achievement.getTotalCorrectAnswer() == null || achievement.getTotalCorrectAnswer() < 0) {
            badRequestBodyErrorMessage.append("totalCorrectAnswer is required. ");
        }
        if(!badRequestBodyErrorMessage.toString().equals("")) {
            throw new BadRequestBodyException(badRequestBodyErrorMessage.toString());
        }
    }

    public void validateTest(Test test, HttpMethod httpMethod) {
        System.out.println(test);
        StringBuilder badRequestBodyErrorMessage = new StringBuilder();
        if(httpMethod == HttpMethod.PUT) {
            if(test.getId() == null || test.getId() <= 0) {
                badRequestBodyErrorMessage.append("id is required. ");
            }
        }
        if(test.getTestName() == null || test.getTestName().equals("")) {
            badRequestBodyErrorMessage.append("testName is required. ");
        }
        if(test.getAudioLink() == null || test.getAudioLink().equals("")) {
            badRequestBodyErrorMessage.append("audioLink is required. ");
        }
        if(!badRequestBodyErrorMessage.toString().equals("")) {
            throw new BadRequestBodyException(badRequestBodyErrorMessage.toString());
        }
    }

    public void validatePart(Part part, HttpMethod httpMethod) {
        System.out.println(part);
        StringBuilder badRequestBodyErrorMessage = new StringBuilder();
        if(httpMethod == HttpMethod.PUT) {
            if(part.getId() == null || part.getId() <= 0) {
                badRequestBodyErrorMessage.append("id is required. ");
            }
        }
        if(part.getTestId() == null || part.getTestId() <= 0) {
            badRequestBodyErrorMessage.append("testId is required. ");
        }
        if(part.getType() == null || part.getType() <= 0) {
            badRequestBodyErrorMessage.append("type is required. ");
        }
        if(part.getTittle() == null || part.getTittle().equals("")) {
            badRequestBodyErrorMessage.append("tittle is required. ");
        }
        if(part.getPartNum() == null || part.getPartNum() <= 0) {
            badRequestBodyErrorMessage.append("partNum is required. ");
        }
        if(part.getDirection() == null || part.getDirection().equals("")) {
            badRequestBodyErrorMessage.append("direction is required. ");
        }
        if(!badRequestBodyErrorMessage.toString().equals("")) {
            throw new BadRequestBodyException(badRequestBodyErrorMessage.toString());
        }
    }

    public void validateQuestionGroup(QuestionGroup questionGroup, HttpMethod httpMethod) {
        System.out.println(questionGroup);
        StringBuilder badRequestBodyErrorMessage = new StringBuilder();
        if(httpMethod == HttpMethod.PUT) {
            if(questionGroup.getId() == null || questionGroup.getId() <= 0) {
                badRequestBodyErrorMessage.append("id is required. ");
            }
        }
        if(questionGroup.getPartId() == null || questionGroup.getPartId() <= 0) {
            badRequestBodyErrorMessage.append("partId is required. ");
        }
//        if(questionGroup.getTittle() == null || questionGroup.getTittle().equals("")) {
//            badRequestBodyErrorMessage.append("tittle is required. ");
//        }
        if(!badRequestBodyErrorMessage.toString().equals("")) {
            throw new BadRequestBodyException(badRequestBodyErrorMessage.toString());
        }
    }

    public void validateQuestion(Question question, HttpMethod httpMethod) {
        System.out.println(question);
        StringBuilder badRequestBodyErrorMessage = new StringBuilder();
        if(httpMethod == HttpMethod.PUT) {
            if(question.getId() == null || question.getId() <= 0) {
                badRequestBodyErrorMessage.append("id is required. ");
            }
        }
        if(!badRequestBodyErrorMessage.toString().equals("")) {
            throw new BadRequestBodyException(badRequestBodyErrorMessage.toString());
        }
    }

    public void validateUser(User user, HttpMethod httpMethod) {
        System.out.println(user);
        StringBuilder badRequestBodyErrorMessage = new StringBuilder();
        if(httpMethod == HttpMethod.PUT) {
            if(user.getId() == null || user.getId() <= 0) {
                badRequestBodyErrorMessage.append("id is required. ");
            }
        }
        if(user.getEmail() == null || user.getEmail().equals("")) {
            badRequestBodyErrorMessage.append("email is required. ");
        } else if(!isValid(user.getEmail())) {
            badRequestBodyErrorMessage.append("incorrect email format. ");
        }
        if(user.getPassword() == null || user.getPassword().equals("")) {
            badRequestBodyErrorMessage.append("password is required. ");
        }
        if(user.getName() == null || user.getName().equals("")) {
            badRequestBodyErrorMessage.append("name is required. ");
        }
        if(user.getRole() == null || user.getRole() <= 0) {
            badRequestBodyErrorMessage.append("role is required. ");
        }
        if(!user.getPassword().equals(user.getConfirmPassword())) {
            badRequestBodyErrorMessage.append("password confirm not match. ");
        }
        if(!badRequestBodyErrorMessage.toString().equals("")) {
            throw new BadRequestBodyException(badRequestBodyErrorMessage.toString());
        }
    }

    public void validateToLogin(User user) {
        System.out.println(user);
        StringBuilder badRequestBodyErrorMessage = new StringBuilder();
        if(user.getEmail() == null || user.getEmail().equals("")) {
            badRequestBodyErrorMessage.append("email is required. ");
        } else if(!isValid(user.getEmail())) {
            badRequestBodyErrorMessage.append("incorrect email format. ");
        }
        if(user.getPassword() == null || user.getPassword().equals("")) {
            badRequestBodyErrorMessage.append("password is required. ");
        }
        if(!badRequestBodyErrorMessage.toString().equals("")) {
            throw new BadRequestBodyException(badRequestBodyErrorMessage.toString());
        }
    }

    private boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
