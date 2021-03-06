package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.model.Part;
import online_toeic_test_springboot.domain.model.Question;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;

public interface ToeicTestReplaceService {

    void replaceTest(Test test);

    void replacePart(Part part);

    void replaceQuestionGroup(QuestionGroup questionGroup);

    void replaceQuestion(Question question);
}
