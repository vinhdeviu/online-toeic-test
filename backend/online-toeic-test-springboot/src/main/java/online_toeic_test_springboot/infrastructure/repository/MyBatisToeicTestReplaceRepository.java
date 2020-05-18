package online_toeic_test_springboot.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.*;
import online_toeic_test_springboot.domain.repository.ToeicTestReplaceRepository;
import online_toeic_test_springboot.exception.EntityExistsException;
import online_toeic_test_springboot.exception.EntityNotFoundException;
import online_toeic_test_springboot.infrastructure.mapper.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class MyBatisToeicTestReplaceRepository implements ToeicTestReplaceRepository {

  private final TestCRUDMapper testCRUDMapper;

  private final PartCRUDMapper partCRUDMapper;

  private final QuestionGroupCRUDMapper questionGroupCRUDMapper;

  private final QuestionCRUDMapper questionCRUDMapper;

  private final AnswerCRUDMapper answerCRUDMapper;

  @Override
  public void replaceTest(Test test) {
    List<Test> testsWithSameName = testCRUDMapper.queryTestsByName(test.getTestName());
    if(testsWithSameName.size() > 0) {
      for(Test testWithSameName: testsWithSameName) {
        if(!testWithSameName.getId().equals(test.getId())) {
          throw new EntityExistsException("test name is duplicated with another test");
        }
      }
    }
    Optional<Test> optionalOldTest = testCRUDMapper.queryTestById(test.getId());
    if(!optionalOldTest.isPresent()) {
      throw new EntityNotFoundException("test not found");
    }
    testCRUDMapper.updateTest(test);
  }

  @Override
  public void replacePart(Part part) {
    Optional<Part> optionalOldPart = partCRUDMapper.queryPartById(part.getId());
    if(!optionalOldPart.isPresent()) {
      throw new EntityNotFoundException("part not found");
    }
    partCRUDMapper.updatePart(part);
  }
  
  @Override
  public void replaceQuestionGroup(QuestionGroup questionGroup) {
    Optional<QuestionGroup> optionalOldQuestionGroup = questionGroupCRUDMapper.queryQuestionGroupById(questionGroup.getId());
    if(!optionalOldQuestionGroup.isPresent()) {
      throw new EntityNotFoundException("question group not found");
    }
    questionGroupCRUDMapper.updateQuestionGroup(questionGroup);
  }

  @Override
  public void replaceQuestion(Question question) {
    Optional<Question> optionalOldQuestion = questionCRUDMapper.queryQuestionById(question.getId());
    if(!optionalOldQuestion.isPresent()) {
      throw new EntityNotFoundException("question not found");
    }
    questionCRUDMapper.updateQuestion(question);
    Map<Character, Answer> answers = question.getAnswers();
    if(answers == null) {
      return;
    }
    for (Map.Entry<Character, Answer> answerEntry : answers.entrySet()) {
      Answer answer = answerEntry.getValue();
      answerCRUDMapper.updateAnswer(answer);
    }
  }
}
