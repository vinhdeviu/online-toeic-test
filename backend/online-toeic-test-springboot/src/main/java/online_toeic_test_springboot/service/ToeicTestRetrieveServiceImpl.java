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

  public List<Test> getAllTests() {
    return toeicTestRetrieveRepository.getAllTests();
  }

  @Override
  public List<Part> getAllParts() {
    return toeicTestRetrieveRepository.getAllParts();
  }

  @Override
  public List<QuestionGroup> getAllQuestionGroups() {
    return toeicTestRetrieveRepository.getAllQuestionGroups();
  }

  @Override
  public List<Question> getAllQuestions() {
    return toeicTestRetrieveRepository.getAllQuestions();
  }

  @Override
  public List<Answer> getAllAnswers() {
    return toeicTestRetrieveRepository.getAllAnswers();
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

  @Override
  public List<Achievement> getAllAchievements() {
    return toeicTestRetrieveRepository.getAllAchievements();
  }

  @Override
  public List<ExamineeAnswer> getAllExamineeAnswers() {
    return toeicTestRetrieveRepository.getAllExamineeAnswers();
  }

  @Override
  public Achievement getAchievementById(int id) {
    return toeicTestRetrieveRepository.getAchievementById(id);
  }

  private Part generatePartWithOnlyQuestions(int testId, int partNum, boolean shuffleQuestionsFlag, boolean shuffleAnswersFlag) {
    Part part = toeicTestRetrieveRepository.getPartByTestIdAndPartNum(testId, partNum);
    //1> get the part from database by testID and PartNum
    List<Question> questions = toeicTestRetrieveRepository.getQuestionsByPartId(part.getId());
    //2> get all question of this part
    part.setQuestions(shuffleQuestionsWithAnswers(questions, shuffleQuestionsFlag, shuffleAnswersFlag));
    //3> shuffle questions and their answers
    return part;
  }

  private Part generatePartWithQuestionGroups(int testId, int partNum, boolean shuffleQuestionGroupsFlag, boolean shuffleQuestionsFlag, boolean shuffleAnswersFlag) {
    Part part = toeicTestRetrieveRepository.getPartByTestIdAndPartNum(testId, partNum);
    //1> get the part from database by testID and PartNum
    List<QuestionGroup> questionGroups = toeicTestRetrieveRepository.getQuestionGroupsByPartId(part.getId());
    if(shuffleQuestionGroupsFlag) {
      Collections.shuffle(questionGroups);
    }
    //2> get all question group and shuffle them if these group can be shuffled
    for(QuestionGroup questionGroup: questionGroups) {
      List<Question> questions = toeicTestRetrieveRepository.getQuestionsByGroupId(questionGroup.getId());
      questionGroup.setQuestions(shuffleQuestionsWithAnswers(questions, shuffleQuestionsFlag, shuffleAnswersFlag));
    }
    //3> after, shuffle question and their answers
    part.setQuestionGroups(questionGroups);
    return part;
  }

  private List<Question> shuffleQuestionsWithAnswers(List<Question> questions, boolean shuffleQuestionsFlag, boolean shuffleAnswersFlag) {
    if(shuffleQuestionsFlag) {
      Collections.shuffle(questions);
      //1> shuffle question if possible
    }
    for(Question question: questions) {
      question.setQuestionNo(++questionNoIndex);
      //2> set number index for question
      List<Answer> answers = toeicTestRetrieveRepository.getAnswersByQuestionId(question.getId());
      if(question.getCorrectAnswerId() == null && answers.isEmpty()) {
        question.setAnswers(null);
        continue;
      }
      if(shuffleAnswersFlag) {
        Collections.shuffle(answers);
      }
      Map<Character, Answer> answerMap = new HashMap<>();
      for(int i = 0; i < answers.size(); i++) {
        Answer answer = answers.get(i);
        char option = TestConfig.ANSWERS_CHAR_VALUES.get(i);
        answerMap.put(option, answer);
        //3> put option to the answer
        if(answer.getId().equals(question.getCorrectAnswerId())) {
          question.setCorrectAnswer(option);
        }
        //4> set the correct answer
      }
      question.setAnswers(answerMap);
    }
    return questions;
  }

  public Test retrieveTestByIdAndShuffle(int testId) {
    questionNoIndex = 0;
    Test test = toeicTestRetrieveRepository.getTestById(testId);
    //get all the test by test id
    Map<Integer, Part> partMap = new HashMap<>();
    for(int partNum = 1; partNum <= TestConfig.TOTAL_PARTS; partNum++) {
      Part part = null;
      boolean shuffleQuestionsFlag = TestConfig.SHUFFLE_QUESTION_PARTS.contains(partNum);
      boolean shuffleAnswersFlag = TestConfig.SHUFFLE_ANSWER_PARTS.contains(partNum);
      if(TestConfig.PARTS_WITHOUT_QUESTION_GROUP.contains(partNum)) {
        part = generatePartWithOnlyQuestions(testId, partNum, shuffleQuestionsFlag, shuffleAnswersFlag);
      }
      //get part 1, 2, 3, 4, 5
      if(TestConfig.PARTS_WITH_QUESTION_GROUP.contains(partNum)) {
        boolean shuffleQuestionGroupsFlag = TestConfig.SHUFFLE_QUESTION_GROUP_PARTS.contains(partNum);
        part = generatePartWithQuestionGroups(testId, partNum,shuffleQuestionGroupsFlag, shuffleQuestionsFlag, shuffleAnswersFlag);
      }
      //get part 5, 7
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
      //add questions to question group
      if(part.getQuestions() != null) {
        allQuestions.addAll(part.getQuestions());
      }
    }
    List<Character> examineeSelectedOptions = Arrays.asList(new Character[allQuestions.size()]);
    List<ExamineeAnswer> examineeAnswers = toeicTestRetrieveRepository.getExamineeAnswersByAchievementId(achievement.getId());
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
  public List<Achievement> getAchievementsByExamineeId(int examineeId) {
    return toeicTestRetrieveRepository.getAchievementsByExamineeId(examineeId);
  }

  @Override
  public TestInfor getTestInfor(int testId) {
    int totalNumQuestions = toeicTestRetrieveRepository.qetTotalNumQuestionsByTestId(testId);
    int totalTimeInSecond = TestConfig.TIME_PER_TEST_IN_SECOND;
    return new TestInfor(totalTimeInSecond, totalNumQuestions);
  }
}
