package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.model.*;

public interface ToeicTestUpdateService {

    void updateTest(Test test);

    void updatePart(Part part);

    void updateQuestionGroup(QuestionGroup questionGroup);

    void updateQuestion(Question question);
}
