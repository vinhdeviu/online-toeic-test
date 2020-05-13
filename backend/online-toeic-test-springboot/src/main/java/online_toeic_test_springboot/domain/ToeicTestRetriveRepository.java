package online_toeic_test_springboot.domain;


import java.util.List;

public interface ToeicTestRetriveRepository {

    List<Test> getAllTests();

    Test getTestById(int id);

    Part getPartByTestIdAndPartNum(int testId, int partNum);

    List<Question> getQuestionsByPartId(int partId);

    List<QuestionGroup> getGroupsByPartId(int partId);

    List<Question> getQuestionsByGroupId(int groupId);

    List<Answer> getAnswersByQuestionId(int questionId);
}
