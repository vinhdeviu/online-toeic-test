package online_toeic_test_springboot.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.*;
import online_toeic_test_springboot.domain.repository.ToeicTestDeleteRepository;
import online_toeic_test_springboot.infrastructure.mapper.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class MyBatisToeicTestDeleteRepository implements ToeicTestDeleteRepository {

  private final TestCRUDMapper testCRUDMapper;

  private final PartCRUDMapper partCRUDMapper;

  private final QuestionGroupCRUDMapper questionGroupCRUDMapper;

  private final QuestionCRUDMapper questionCRUDMapper;

  private final AnswerCRUDMapper answerCRUDMapper;

  @Override
  public void deleteTestById(int id) {
    testCRUDMapper.deleteTestById(id);
    List<Part> parts = partCRUDMapper.queryPartsByTestId(id);
    for(Part part: parts) {
      deletePartById(part.getId());
    }
  }

  @Override
  public void deletePartById(int id) {
    partCRUDMapper.deletePartById(id);
    List<QuestionGroup> QuestionGroup = questionGroupCRUDMapper.queryQuestionGroupsByPartId(id);
    for(QuestionGroup questionGroup: QuestionGroup) {
      deleteQuestionGroupById(questionGroup.getId());
    }
    List<Question> questions = questionCRUDMapper.queryQuestionsByPartId(id);
    for(Question question: questions) {
      deleteQuestionById(question.getId());
    }
  }

  @Override
  public void deleteQuestionGroupById(int id) {
    questionGroupCRUDMapper.deleteQuestionGroupById(id);
    List<Question> questions = questionCRUDMapper.queryQuestionsByGroupId(id);
    for(Question question: questions) {
      deleteQuestionById(question.getId());
    }
  }

  @Override
  public void deleteQuestionById(int id) {
    questionCRUDMapper.deleteQuestionById(id);
    answerCRUDMapper.deleteAnswersByQuestionId(id);
  }
}
