package online_toeic_test_springboot.domain.repository;

import online_toeic_test_springboot.domain.model.*;

import java.util.List;

public interface ToeicTestRetrieveRepository {

    List<Test> getAllTests();

    Test getTestById(int id);

    Part getPartByTestIdAndPartNum(int testId, int partNum);

    List<Question> getQuestionsByPartId(int partId);

    List<QuestionGroup> getQuestionGroupsByPartId(int partId);

    List<Question> getQuestionsByGroupId(int groupId);

    List<Answer> getAnswersByQuestionId(int questionId);

    List<Achievement> getAchievementByExamineeId(int examineeId);

    Achievement getAchievementById(int id);
}
