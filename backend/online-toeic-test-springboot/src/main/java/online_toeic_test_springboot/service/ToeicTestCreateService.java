package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.model.Achievement;
import online_toeic_test_springboot.domain.model.Question;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;

public interface ToeicTestCreateService {

    void createAchievement(Achievement achievement);

    void createNewToeicTest(Test test);

    void createNewQuestionGroup(QuestionGroup questionGroup);

    void createNewQuestion(Question question);
}
