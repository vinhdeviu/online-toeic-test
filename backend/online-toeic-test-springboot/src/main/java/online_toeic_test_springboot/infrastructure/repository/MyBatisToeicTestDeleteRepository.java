package online_toeic_test_springboot.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.*;
import online_toeic_test_springboot.domain.repository.ToeicTestDeleteRepository;
import online_toeic_test_springboot.exception.EntityNotFoundException;
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

  private boolean executeDeleteTestById(int id) {
    boolean deleted = testCRUDMapper.deleteTestById(id);
    if(!deleted) {
      return false;
    }
    List<Part> parts = partCRUDMapper.queryPartsByTestId(id);
    for(Part part: parts) {
      deletePartById(part.getId());
    }
    return true;
  }

  private boolean executeDeletePartById(int id) {
    boolean deleted = partCRUDMapper.deletePartById(id);
    if(!deleted) {
      return false;
    }
    List<QuestionGroup> QuestionGroup = questionGroupCRUDMapper.queryQuestionGroupsByPartId(id);
    for(QuestionGroup questionGroup: QuestionGroup) {
      deleteQuestionGroupById(questionGroup.getId());
    }
    List<Question> questions = questionCRUDMapper.queryQuestionsByPartId(id);
    for(Question question: questions) {
      deleteQuestionById(question.getId());
    }
    return true;
  }

  private boolean executeDeleteQuestionGroupById(int id) {
    boolean deleted = questionGroupCRUDMapper.deleteQuestionGroupById(id);
    if(!deleted) {
      return false;
    }
    List<Question> questions = questionCRUDMapper.queryQuestionsByGroupId(id);
    for(Question question: questions) {
      deleteQuestionById(question.getId());
    }
    return true;
  }

  private boolean executeDeleteQuestionById(int id) {
    boolean deleted = questionCRUDMapper.deleteQuestionById(id);
    if(!deleted) {
      return false;
    }
    answerCRUDMapper.deleteAnswersByQuestionId(id);
    return true;
  }
  @Override
  public void deleteTestById(int id) {
    if(!executeDeleteTestById(id)) {
      throw new EntityNotFoundException("test not found");
    }
  }

  @Override
  public void deletePartById(int id) {
    if(!executeDeletePartById(id)) {
      throw new EntityNotFoundException("part not found");
    }
  }

  @Override
  public void deleteQuestionGroupById(int id) {
    if(!executeDeleteQuestionGroupById(id)) {
      throw new EntityNotFoundException("question group not found");
    }
  }

  @Override
  public void deleteQuestionById(int id) {
    if(!executeDeleteQuestionById(id)) {
      throw new EntityNotFoundException("question not found");
    }
  }
}
