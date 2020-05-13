package online_toeic_test_springboot.domain.repository;

import online_toeic_test_springboot.domain.model.*;

public interface ToeicTestUpdateRepository {

    void updateTest(Test test);

    void updatePart(Part part);

    void updateQuestionGroup(QuestionGroup questionGroup);

    void updateQuestion(Question question);
}
