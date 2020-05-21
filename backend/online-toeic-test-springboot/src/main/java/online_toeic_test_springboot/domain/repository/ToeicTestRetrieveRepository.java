package online_toeic_test_springboot.domain.repository;

import online_toeic_test_springboot.domain.model.*;

import java.util.List;

public interface ToeicTestRetrieveRepository {

    List<Test> getAllTests();

    List<Part> getAllParts();

    List<QuestionGroup> getAllQuestionGroups();

    List<Question> getAllQuestions();

    List<Answer> getAllAnswers();

    Test getTestById(int id);

    List<Part> getPartsByTestId(int testId);

    Part getPartById(int id);

    Part getPartByTestIdAndPartNum(int testId, int partNum);

    List<Question> getQuestionsByPartId(int partId);

    List<QuestionGroup> getQuestionGroupsByPartId(int partId);

    QuestionGroup getQuestionGroupById(int id);

    List<Question> getQuestionsByGroupId(int groupId);

    Question getQuestionById(int id);

    List<Answer> getAnswersByQuestionId(int questionId);

    List<Achievement> getAchievementsByExamineeId(int examineeId);

    Achievement getAchievementById(int id);

    int qetTotalNumQuestionsByTestId(int testId);

    List<Achievement> getAllAchievements();

    List<ExamineeAnswer> getExamineeAnswersByAchievementId(int achievementId);

    List<ExamineeAnswer> getAllExamineeAnswers();
}
