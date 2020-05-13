package online_toeic_test_springboot.domain.repository;

import online_toeic_test_springboot.domain.model.Achievement;
import online_toeic_test_springboot.domain.model.Question;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;

public interface ToeicTestCreateRepository {

    void createAchievement(Achievement achievement);

    void createTest(Test test);

    void createQuestionGroup(QuestionGroup questionGroup);

    void createQuestion(Question question);
}
