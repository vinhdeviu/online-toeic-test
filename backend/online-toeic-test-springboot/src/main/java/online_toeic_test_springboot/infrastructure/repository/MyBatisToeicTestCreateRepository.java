package online_toeic_test_springboot.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.*;
import online_toeic_test_springboot.exception.EntityNotFoundException;
import online_toeic_test_springboot.infrastructure.mapper.*;
import online_toeic_test_springboot.domain.repository.ToeicTestCreateRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class MyBatisToeicTestCreateRepository implements ToeicTestCreateRepository {

  private final TestCRUDMapper testCRUDMapper;

  private final PartCRUDMapper partCRUDMapper;

  private final QuestionGroupCRUDMapper questionGroupCRUDMapper;

  private final QuestionCRUDMapper questionCRUDMapper;

  private final AnswerCRUDMapper answerCRUDMapper;

  private final AchievementCRUDMapper achievementCRUDMapper;

  private final ExamineeAnswerCRUDMapper examineeAnswerCRUDMapper;

  @Override
  public void createAchievement(Achievement achievement) {
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    achievement.setDate(dateFormat.format(date));
    achievementCRUDMapper.insertAchievement(achievement);
    for(ExamineeAnswer examineeAnswer: achievement.getExamineeAnswers()) {
      if(examineeAnswer == null) continue;
      examineeAnswer.setAchievementId(achievement.getId());
      examineeAnswerCRUDMapper.insertExamineeAnswer(examineeAnswer);
    }
  }

  @Override
  public void createTest(Test test) {
    testCRUDMapper.insertTest(test);
    int testId = test.getId();
    Optional<Test> optionalTestTemplate = testCRUDMapper.queryTheFirstTest();
    for(int i = 1; i <= 7; i++) {
      Part part = new Part();
      part.setTestId(testId);
      part.setPartNum(i);
      if(i <= 4) {
        part.setType(1);
      } else {
        part.setType(2);
      }
      String tittle = "";
      String direction = "";
      if(optionalTestTemplate.isPresent()) {
        Optional<Part> optionalPartTemplate = partCRUDMapper.queryPartByTestIdAndPartNum(1, i);
        if(optionalPartTemplate.isPresent()) {
          Part partTemplate = optionalPartTemplate.get();
          tittle = partTemplate.getTittle();
          direction = partTemplate.getDirection();
        }
      }
      part.setTittle(tittle);
      part.setDirection(direction);
      partCRUDMapper.insertPart(part);
    }
  }

  @Override
  public void createQuestionGroup(QuestionGroup questionGroup) {
    questionGroupCRUDMapper.insertQuestionGroup(questionGroup);
  }

  @Override
  public void createQuestion(Question question) {
    questionCRUDMapper.insertQuestion(question);
    Optional<Part> optionalPart = partCRUDMapper.queryPartById(question.getPartId());
    if(!optionalPart.isPresent()) {
      throw new EntityNotFoundException("part not found");
    }
    int partNum = optionalPart.get().getPartNum();
    if(partNum <= 2) {
      return;
    }
    for(int i = 0; i < 4; i++) {
      Answer answer = new Answer();
      answer.setQuestionId(question.getId());
      answer.setContent("");
      answerCRUDMapper.insertAnswer(answer);
    }
  }
}
