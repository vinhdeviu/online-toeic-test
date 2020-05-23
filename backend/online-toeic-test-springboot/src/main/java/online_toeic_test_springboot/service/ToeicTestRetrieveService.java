package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.model.*;

import java.util.List;

public interface ToeicTestRetrieveService {

    List<Test> getAllTests();

    List<Part> getAllParts();

    List<QuestionGroup> getAllQuestionGroups();

    List<Question> getAllQuestions();

    List<Answer> getAllAnswers();

    Test getTestById(int id);

    List<Part> getPartsByTestId(int testId);

    Part getPartById(int id);

    List<Question> getQuestionsByPartId(int partId);

    List<QuestionGroup> getQuestionGroupsByPartId(int partId);

    List<Question> getQuestionsByGroupId(int groupId);

    Question getQuestionById(int id);

    List<Answer> getAnswersByQuestionId(int questionId);

    Test retrieveTestByIdAndShuffle(int testId);

    Test retrieveTestByAchievementIdAndShuffle(int achievementId);

    List<Achievement> getAchievementsByExamineeId(int examineeId);

    TestInfor getTestInfor(int testId);

    QuestionGroup getQuestionGroupById(int id);

    List<Achievement> getAllAchievements();

    List<ExamineeAnswer> getAllExamineeAnswers();

    Achievement getAchievementById(int id);
}
