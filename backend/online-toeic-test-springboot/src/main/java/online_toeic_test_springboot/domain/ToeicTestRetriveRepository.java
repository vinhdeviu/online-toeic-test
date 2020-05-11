package online_toeic_test_springboot.domain;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface ToeicTestRetriveRepository {

    List<Test> queryAllTests();

    Test queryTestById(int id);

    Part queryPartByTestIdAndPartNum(int testId, int partNum);

    List<Question> queryQuestionsByPartId(int partId);

    List<QuestionGroup> queryGroupsByPartId(int partId);

    List<Question> queryQuestionsByGroupId(int groupId);

    List<Answer> queryAnswersByQuestionId(int questionId);
}
