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
        char option = (char) (65+i);
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
  public Test retrieveTestByAchievementIdAndShuffle(int achievementId) {
    Achievement achievement = toeicTestRetrieveRepository.getAchievementById(achievementId);
    Test test = retrieveTestByIdAndShuffle(achievement.getTestId());
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
            continue;
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
  public TestInfor getTestInfor() {
    return new TestInfor(120*60, 200);
  }
}
