package online_toeic_test_springboot.data;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.*;
import online_toeic_test_springboot.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class MyBatisToeicTestRetriveRepository implements ToeicTestRetriveRepository {

  private final ToeicTestRetriveMapper toeicTestRetriveMapper;

  @Override
  public List<Test> getAllTests() {
    return toeicTestRetriveMapper.queryAllTests();
  }

  @Override
  public Test getTestById(int id) {
    Optional<Test> test = toeicTestRetriveMapper.queryTestById(id);
    if(!test.isPresent()) {
      throw new EntityNotFoundException("test not found");
    }
    return test.get();
  }

  @Override
  public Part getPartByTestIdAndPartNum(int testId, int partNum) {
    Optional<Part> part = toeicTestRetriveMapper.queryPartByTestIdAndPartNum(testId, partNum);
    if(!part.isPresent()) {
      throw new EntityNotFoundException("part not found");
    }
    return part.get();
  }

  @Override
  public List<Question> getQuestionsByPartId(int partId) {
    return toeicTestRetriveMapper.queryQuestionsByPartId(partId);
  }

  @Override
  public List<QuestionGroup> getGroupsByPartId(int partId) {
    return toeicTestRetriveMapper.queryGroupsByPartId(partId);
  }

  @Override
  public List<Question> getQuestionsByGroupId(int groupId) {
    return toeicTestRetriveMapper.queryQuestionsByGroupId(groupId);
  }

  @Override
  public List<Answer> getAnswersByQuestionId(int questionId) {
    return toeicTestRetriveMapper.queryAnswersByQuestionId(questionId);
  }
}
