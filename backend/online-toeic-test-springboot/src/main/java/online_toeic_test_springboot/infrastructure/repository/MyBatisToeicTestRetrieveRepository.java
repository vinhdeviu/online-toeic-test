package online_toeic_test_springboot.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.infrastructure.mapper.*;
import online_toeic_test_springboot.domain.model.*;
import online_toeic_test_springboot.domain.repository.ToeicTestRetrieveRepository;
import online_toeic_test_springboot.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyBatisToeicTestRetrieveRepository implements ToeicTestRetrieveRepository {

  private final TestCRUDMapper testCRUDMapper;

  private final PartCRUDMapper partCRUDMapper;

  private final QuestionGroupCRUDMapper questionGroupCRUDMapper;

  private final QuestionCRUDMapper questionCRUDMapper;

  private final AnswerCRUDMapper answerCRUDMapper;

  private final AchievementCRUDMapper achievementCRUDMapper;

  private final ExamineeAnswerCRUDMapper examineeAnswerCRUDMapper;

  @Override
  public List<Test> getAllTests() {
    return testCRUDMapper.queryAllTests();
  }

  @Override
  public List<Part> getAllParts() {
    return partCRUDMapper.queryAllParts();
  }

  @Override
  public List<QuestionGroup> getAllQuestionGroups() {
    return questionGroupCRUDMapper.queryAllQuestionGroups();
  }

  @Override
  public List<Question> getAllQuestions() {
    return questionCRUDMapper.queryAllQuestions();
  }

  @Override
  public List<Answer> getAllAnswers() {
    return answerCRUDMapper.queryAllAnswers();
  }

  @Override
  public Test getTestById(int id) {
    Optional<Test> test = testCRUDMapper.queryTestById(id);
    if(!test.isPresent()) {
      throw new EntityNotFoundException("test not found");
    }
    return test.get();
  }

  @Override
  public List<Part> getPartsByTestId(int testId) {
    return partCRUDMapper.queryPartsByTestId(testId);
  }

  @Override
  public Part getPartById(int id) {
    Optional<Part> part = partCRUDMapper.queryPartById(id);
    if(!part.isPresent()) {
      throw new EntityNotFoundException("part not found");
    }
    return part.get();
  }

  @Override
  public Part getPartByTestIdAndPartNum(int testId, int partNum) {
    Optional<Part> part = partCRUDMapper.queryPartByTestIdAndPartNum(testId, partNum);
    if(!part.isPresent()) {
      throw new EntityNotFoundException("part not found");
    }
    return part.get();
  }

  @Override
  public List<Question> getQuestionsByPartId(int partId) {
    return questionCRUDMapper.queryQuestionsByPartId(partId);
  }

  @Override
  public List<QuestionGroup> getQuestionGroupsByPartId(int partId) {
    return questionGroupCRUDMapper.queryQuestionGroupsByPartId(partId);
  }

  @Override
  public QuestionGroup getQuestionGroupById(int id) {
    Optional<QuestionGroup> questionGroup = questionGroupCRUDMapper.queryQuestionGroupById(id);
    if(!questionGroup.isPresent()) {
      throw new EntityNotFoundException("question group not found");
    }
    return questionGroup.get();
  }

  @Override
  public List<Question> getQuestionsByGroupId(int groupId) {
    return questionCRUDMapper.queryQuestionsByGroupId(groupId);
  }

  @Override
  public Question getQuestionById(int id) {
    Optional<Question> question = questionCRUDMapper.queryQuestionById(id);
    if(!question.isPresent()) {
      throw new EntityNotFoundException("question not found");
    }
    return question.get();
  }

  @Override
  public List<Answer> getAnswersByQuestionId(int questionId) {
    return answerCRUDMapper.queryAnswersByQuestionId(questionId);
  }

  @Override
  public List<Achievement> getAchievementsByExamineeId(int examineeId) {
    return achievementCRUDMapper.queryAchievementsByExamineeId(examineeId);
  }

  @Override
  public Achievement getAchievementById(int id) {
    Optional<Achievement> optionalAchievement = achievementCRUDMapper.queryAchievementById(id);
    if(!optionalAchievement.isPresent()) {
      throw new EntityNotFoundException("achievement not found");
    }
    return optionalAchievement.get();
  }

  @Override
  public int qetTotalNumQuestionsByTestId(int testId) {
    return questionCRUDMapper.queryCountTotalQuestionsByTestId(testId);
  }

  @Override
  public List<Achievement> getAllAchievements() {
    return achievementCRUDMapper.queryAllAchievements();
  }

  @Override
  public List<ExamineeAnswer> getExamineeAnswersByAchievementId(int achievementId) {
    return examineeAnswerCRUDMapper.queryExamineeAnswersByAchievementId(achievementId);
  }

  @Override
  public List<ExamineeAnswer> getAllExamineeAnswers() {
    return examineeAnswerCRUDMapper.queryAllExamineeAnswers();
  }
}
