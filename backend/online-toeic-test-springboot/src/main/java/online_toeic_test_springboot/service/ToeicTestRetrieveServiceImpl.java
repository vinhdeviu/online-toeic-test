package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.*;
import online_toeic_test_springboot.domain.repository.ToeicTestRetrieveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ToeicTestRetrieveServiceImpl implements ToeicTestRetrieveService {

  @Autowired
  private final ToeicTestRetrieveRepository toeicTestRetrieveRepository;

  private int questionNoIndex = 0;

  public List<Test> retrieveAllTests() {
    return toeicTestRetrieveRepository.getAllTests();
  }

  @Override
  public Test getTestById(int id) {
    return toeicTestRetrieveRepository.getTestById(id);
  }

  @Override
  public List<Part> getPartsByTestId(int testId) {
    return toeicTestRetrieveRepository.getPartsByTestId(testId);
  }

  @Override
  public Part getPartById(int id) {
    return toeicTestRetrieveRepository.getPartById(id);
  }

  @Override
  public List<Question> getQuestionsByPartId(int partId) {
    return toeicTestRetrieveRepository.getQuestionsByPartId(partId);
  }

  @Override
  public List<QuestionGroup> getQuestionGroupsByPartId(int partId) {
    return toeicTestRetrieveRepository.getQuestionGroupsByPartId(partId);
  }

  @Override
  public List<Question> getQuestionsByGroupId(int groupId) {
    return toeicTestRetrieveRepository.getQuestionsByGroupId(groupId);
  }

  @Override
  public Question getQuestionById(int id) {
    return toeicTestRetrieveRepository.getQuestionById(id);
  }

  @Override
  public List<Answer> getAnswersByQuestionId(int questionId) {
    return toeicTestRetrieveRepository.getAnswersByQuestionId(questionId);
  }

  @Override
  public QuestionGroup getQuestionGroupById(int id) {
    return toeicTestRetrieveRepository.getQuestionGroupById(id);
  }

  private Part generatePartWithOnlyQuestions(int testId, int partNum, boolean shuffleQuestionsFlag, boolean shuffleAnswersFlag) {
    Part part = toeicTestRetrieveRepository.getPartByTestIdAndPartNum(testId, partNum);
    List<Question> questions = toeicTestRetrieveRepository.getQuestionsByPartId(part.getId());
    part.setQuestions(shuffleQuestionsWithAnswers(questions, shuffleQuestionsFlag, shuffleAnswersFlag));
    return part;
  }

  private Part generatePartWithQuestionGroups(int testId, int partNum, boolean shuffleQuestionGroupsFlag, boolean shuffleQuestionsFlag, boolean shuffleAnswersFlag) {
    Part part = toeicTestRetrieveRepository.getPartByTestIdAndPartNum(testId, partNum);
    List<QuestionGroup> questionGroups = toeicTestRetrieveRepository.getQuestionGroupsByPartId(part.getId());
    if(shuffleQuestionGroupsFlag) {
      Collections.shuffle(questionGroups);
    }
    for(QuestionGroup questionGroup: questionGroups) {
      List<Question> questions = toeicTestRetrieveRepository.getQuestionsByGroupId(questionGroup.getId());
      questionGroup.setQuestions(shuffleQuestionsWithAnswers(questions, shuffleQuestionsFlag, shuffleAnswersFlag));
    }
    part.setQuestionGroups(questionGroups);
    return part;
  }

  private List<Question> shuffleQuestionsWithAnswers(List<Question> questions, boolean shuffleQuestionsFlag, boolean shuffleAnswersFlag) {
    if(shuffleQuestionsFlag) {
      Collections.shuffle(questions);
    }
    for(Question question: questions) {
      question.setQuestionNo(++questionNoIndex);
      List<Answer> answers = toeicTestRetrieveRepository.getAnswersByQuestionId(question.getId());
      if(shuffleAnswersFlag) {
        Collections.shuffle(answers);
      }
      Map<Character, Answer> answerMap = new HashMap<>();
      for(int i = 0; i < answers.size(); i++) {
        Answer answer = answers.get(i);
        char option = TestConfig.ANSWERS_CHAR_VALUES.get(i);
        answerMap.put(option, answer);
        if(answer.getId().equals(question.getCorrectAnswerId())) {
          question.setCorrectAnswer(option);
        }
      }
      question.setAnswers(answerMap);
    }
    return questions;
  }

  public Test retrieveTestByIdAndShuffle(int testId) {
    questionNoIndex = 0;
    Test test = toeicTestRetrieveRepository.getTestById(testId);
    Map<Integer, Part> partMap = new HashMap<>();
    for(int partNum = 1; partNum <= TestConfig.TOTAL_PARTS; partNum++) {
      Part part = null;
      boolean shuffleQuestionsFlag = TestConfig.SHUFFLE_QUESTION_PARTS.contains(partNum);
      boolean shuffleAnswersFlag = TestConfig.SHUFFLE_ANSWER_PARTS.contains(partNum);
      if(TestConfig.PARTS_WITHOUT_QUESTION_GROUP.contains(partNum)) {
        part = generatePartWithOnlyQuestions(testId, partNum, shuffleQuestionsFlag, shuffleAnswersFlag);
      }
      if(TestConfig.PARTS_WITH_QUESTION_GROUP.contains(partNum)) {
        boolean shuffleQuestionGroupsFlag = TestConfig.SHUFFLE_QUESTION_GROUP_PARTS.contains(partNum);
        part = generatePartWithQuestionGroups(testId, partNum,shuffleQuestionGroupsFlag, shuffleQuestionsFlag, shuffleAnswersFlag);
      }
      partMap.put(partNum, part);
    }
    test.setParts(partMap);
    return test;
  }

  @Override
  public Test retrieveTestByAchievementIdAndShuffle(int achievementId) {
    Achievement achievement = toeicTestRetrieveRepository.getAchievementById(achievementId);
    int testId = achievement.getTestId();
    Test test = retrieveTestByIdAndShuffle(testId);
    List<Question> allQuestions = new ArrayList<>();
    for (Map.Entry<Integer, Part> partMap : test.getParts().entrySet()) {
      Part part = partMap.getValue();
      if(part.getQuestionGroups() != null) {
        for(QuestionGroup questionGroup: part.getQuestionGroups()) {
          allQuestions.addAll(questionGroup.getQuestions());
        }
      }
      if(part.getQuestions() != null) {
        allQuestions.addAll(part.getQuestions());
      }
    }
    List<Character> examineeSelectedOptions = Arrays.asList(new Character[allQuestions.size()]);
    List<ExamineeAnswer> examineeAnswers = achievement.getExamineeAnswers();
    for(ExamineeAnswer examineeAnswer: examineeAnswers) {
      for(Question question: allQuestions) {
        if(!examineeAnswer.getQuestionId().equals(question.getId())) {
          continue;
        }
        if(examineeAnswer.getAnswerId() == null) {
          examineeSelectedOptions.set(question.getQuestionNo() - 1, examineeAnswer.getOption());
          continue;
        }
        Map<Character, Answer> answers = question.getAnswers();
        for (Map.Entry<Character, Answer> answerEntry : answers.entrySet()) {
          if(examineeAnswer.getAnswerId().equals(answerEntry.getValue().getId())) {
            examineeSelectedOptions.set(question.getQuestionNo() - 1, answerEntry.getKey());
          }
        }
      }
    }
    test.setExamineeSelectedOptions(examineeSelectedOptions);
    return test;
  }

  @Override
  public List<Achievement> getAchievementByExamineeId(int examineeId) {
    return toeicTestRetrieveRepository.getAchievementByExamineeId(examineeId);
  }

  @Override
  public TestInfor getTestInfor(int testId) {
    return new TestInfor(TestConfig.TIME_PER_TEST_IN_SECOND, toeicTestRetrieveRepository.qetTotalNumQuestionsByTestId(testId));
  }
}
