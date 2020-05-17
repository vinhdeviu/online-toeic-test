package online_toeic_test_springboot.validation;

import online_toeic_test_springboot.domain.model.Part;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;
import online_toeic_test_springboot.exception.BadRequestBodyException;
import org.springframework.stereotype.Component;

@Component
public class RequestBodyValidation {

    public void validateTest(Test test) {
        System.out.println(test);
        StringBuilder badRequestBodyErrorMessage = new StringBuilder();
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

    public void validatePart(Part part) {
        System.out.println(part);
        StringBuilder badRequestBodyErrorMessage = new StringBuilder();
        if(part.getTittle() == null || part.getTittle().equals("")) {
            badRequestBodyErrorMessage.append("tittle is required. ");
        }
        if(part.getPartNum() == null || part.getPartNum().equals("")) {
            badRequestBodyErrorMessage.append("partNum is required. ");
        }
        if(part.getDirection() == null || part.getDirection().equals("")) {
            badRequestBodyErrorMessage.append("direction is required. ");
        }
        if(!badRequestBodyErrorMessage.toString().equals("")) {
            throw new BadRequestBodyException(badRequestBodyErrorMessage.toString());
        }
    }

//    public void validateQuestionGroup(QuestionGroup questionGroup) {
//        System.out.println(questionGroup);
//        StringBuilder badRequestBodyErrorMessage = new StringBuilder();
//        if(questionGroup.getTittle() == null || questionGroup.getTittle().equals("")) {
//            badRequestBodyErrorMessage.append("tittle is required. ");
//        }
//        if(part.getPartNum() == null || part.getPartNum().equals("")) {
//            badRequestBodyErrorMessage.append("partNum is required. ");
//        }
//        if(part.getDirection() == null || part.getDirection().equals("")) {
//            badRequestBodyErrorMessage.append("direction is required. ");
//        }
//        if(!badRequestBodyErrorMessage.toString().equals("")) {
//            throw new BadRequestBodyException(badRequestBodyErrorMessage.toString());
//        }
//    }
}
