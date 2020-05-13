package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ToeicTestServiceImpl implements ToeicTestService {

  @Autowired
  private final ToeicTestRetriveRepository toeicTestRetriveRepository;

  @Autowired
  private final AchievementRepository achievementRepository;

  private int questionNoIndex = 0;

  public List<Test> retrieveAllTests() {
    return toeicTestRetriveRepository.getAllTests();
  }

  private Part generatePartWithOnlyQuestions(int testId, int partNum, boolean shuffleQuestionsFlag, boolean shuffleAnswersFlag) {
    Part part = toeicTestRetriveRepository.getPartByTestIdAndPartNum(testId, partNum);
    List<Question> questions = toeicTestRetriveRepository.getQuestionsByPartId(part.getId());
    part.setQuestions(shuffleQuestionsWithAnswers(questions, shuffleQuestionsFlag, shuffleAnswersFlag));
    return part;
  }

  private Part generatePartWithQuestionGroups(int testId, int partNum, boolean shuffleQuestionGroupsFlag, boolean shuffleQuestionsFlag, boolean shuffleAnswersFlag) {
    Part part = toeicTestRetriveRepository.getPartByTestIdAndPartNum(testId, partNum);
    List<QuestionGroup> questionGroups = toeicTestRetriveRepository.getGroupsByPartId(part.getId());
    if(shuffleQuestionGroupsFlag) {
      Collections.shuffle(questionGroups);
    }
    for(QuestionGroup questionGroup: questionGroups) {
      List<Question> questions = toeicTestRetriveRepository.getQuestionsByGroupId(questionGroup.getId());
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
      List<Answer> answers = toeicTestRetriveRepository.getAnswersByQuestionId(question.getId());
      if(shuffleAnswersFlag) {
        Collections.shuffle(answers);
      }
      Map<Character, Answer> answerMap = new HashMap<>();
      for(int i = 0; i < answers.size(); i++) {
        Answer answer = answers.get(i);
        char option = (char) (65+i);
        answerMap.put(option, answer);
        if(answer.getId() == question.getCorrectAnswerId()) {
          question.setCorrectAnswer(option);
        }
      }
      question.setAnswers(answerMap);
    }
    return questions;
  }

  public Test generateTest(int testId) {
    questionNoIndex = 0;
    Test test = toeicTestRetriveRepository.getTestById(testId);
    Part part1 = generatePartWithOnlyQuestions(testId, 1, false, false);
    Part part2 = generatePartWithOnlyQuestions(testId, 2, false, false);
    Part part3 = generatePartWithOnlyQuestions(testId, 3, false, true);
    Part part4 = generatePartWithOnlyQuestions(testId, 4, false, true);
    Part part5 = generatePartWithOnlyQuestions(testId, 5, true, true);
    Part part6 = generatePartWithQuestionGroups(testId, 6,false, false, true);
    Part part7 = generatePartWithQuestionGroups(testId, 7,true, true, true);
    Map<Integer, Part> partMap = new HashMap<>();
    partMap.put(1, part1);
    partMap.put(2, part2);
    partMap.put(3, part3);
    partMap.put(4, part4);
    partMap.put(5, part5);
    partMap.put(6, part6);
    partMap.put(7, part7);
    test.setParts(partMap);
    return test;
  }

  @Override
  public Test generateTestByAchievementId(int achievementId) {
    Achievement achievement = achievementRepository.getAchievementById(achievementId);
    Test test = generateTest(achievement.getTestId());
    achievement.setTest(test);
    achievement.setTestName(test.getTestName());
    List<Question> allQuestions = new ArrayList<>();
    List<Question> questionsPart1 = test.getParts().get(1).getQuestions();
    allQuestions.addAll(questionsPart1);
    List<Question> questionsPart2 = test.getParts().get(2).getQuestions();
    allQuestions.addAll(questionsPart2);
    List<Question> questionsPart3 = test.getParts().get(3).getQuestions();
    allQuestions.addAll(questionsPart3);
    List<Question> questionsPart4 = test.getParts().get(4).getQuestions();
    allQuestions.addAll(questionsPart4);
    List<Question> questionsPart5 = test.getParts().get(5).getQuestions();
    allQuestions.addAll(questionsPart5);
    List<QuestionGroup> questionGroupsPart6 = test.getParts().get(6).getQuestionGroups();
    for(QuestionGroup questionGroupPart6: questionGroupsPart6) {
      List<Question> questionsPart6 = questionGroupPart6.getQuestions();
      allQuestions.addAll(questionsPart6);
    }
    List<QuestionGroup> questionGroupsPart7 = test.getParts().get(7).getQuestionGroups();
    for(QuestionGroup questionGroupPart7: questionGroupsPart7) {
      List<Question> questionsPart7 = questionGroupPart7.getQuestions();
      allQuestions.addAll(questionsPart7);
    }

    List<Character> examineeSelectedOptions = Arrays.asList(new Character[allQuestions.size()]);
    List<ExamineeAnswer> examineeAnswers = achievement.getExamineeAnswers();
    for(ExamineeAnswer examineeAnswer: examineeAnswers) {
      for(Question question: allQuestions) {
        if(examineeAnswer.getQuestionId() != question.getId()) {
          continue;
        }
        if(examineeAnswer.getAnswerId() == 0) {
          examineeSelectedOptions.set(question.getQuestionNo() - 1, examineeAnswer.getOption());
          continue;
        }
        Map<Character, Answer> answers = question.getAnswers();
        for (Map.Entry<Character, Answer> answer : answers.entrySet()) {
          //System.out.println("Key : " + answer.getKey() + " Value : " + answer.getValue());
          if(examineeAnswer.getAnswerId() == answer.getValue().getId()) {
            examineeSelectedOptions.set(question.getQuestionNo() - 1, answer.getKey());
            continue;
          }
        }
      }
    }
    test.setExamineeSelectedOptions(examineeSelectedOptions);
    return test;
  }

  @Override
  public TestInfor getTestInfor() {
    return new TestInfor(120*60, 200);
  }
}
