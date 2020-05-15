package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.model.*;

import java.util.List;

public interface ToeicTestRetrieveService {

    List<Test> retrieveAllTests();

    Test getTestById(int id);

    List<Part> getPartsByTestId(int testId);

    Part getPartById(int id);

    List<Question> getQuestionsByPartId(int partId);

    List<QuestionGroup> getQuestionGroupsByPartId(int partId);

    List<Question> getQuestionsByGroupId(int groupId);

    Test retrieveTestByIdAndShuffle(int testId);

    Test retrieveTestByAchievementIdAndShuffle(int achievementId);

    List<Achievement> getAchievementByExamineeId(int examineeId);

    TestInfor getTestInfor();

    boolean isAbleToAddNewQuestion(int testId);

    QuestionGroup getQuestionGroupById(int id);
}
