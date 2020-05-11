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

  public List<Test> retrieveAllTests() {
    return toeicTestRetriveRepository.queryAllTests();
  }

//  private PartWithQuestionOutput generatePartWithQuestionOutput(int testId, int partNum) {
//    Part part = toeicTestRetriveRepository.queryPartByTestIdAndPartNum(testId, partNum);
//    System.out.println(part);
//    List<Question> questions = toeicTestRetriveRepository.queryQuestionsByPartId(part.getId());
//    System.out.println(questions);
//    List<QuestionOutput> questionOutputList = new ArrayList<>();
//    for(Question question: questions) {
//      List<Answer> answers = toeicTestRetriveRepository.queryAnswersByQuestionId(question.getId());
//      System.out.println(answers);
//      QuestionOutput questionOutput = new QuestionOutput(question, answers);
//      questionOutputList.add(questionOutput);
//    }
//    return new PartWithQuestionOutput(part, questionOutputList);
//  }
//
//  private PartWithQuestionGroupOutput generatePartWithQuestionGroupOutput(int testId, int partNum) {
//    Part part = toeicTestRetriveRepository.queryPartByTestIdAndPartNum(testId, partNum);
//    System.out.println(part);
//    List<QuestionGroup> questionGroups = toeicTestRetriveRepository.queryGroupsByPartId(part.getId());
//    System.out.println(questionGroups);
//    List<QuestionGroupOutput> questionGroupOutputList = new ArrayList<>();
//    for(QuestionGroup questionGroup: questionGroups) {
//      List<Question> questions = toeicTestRetriveRepository.queryQuestionsByGroupId(questionGroup.getId());
//      System.out.println(questions);
//      List<QuestionOutput> questionOutputList = new ArrayList<>();
//      for(Question question: questions) {
//        List<Answer> answers = toeicTestRetriveRepository.queryAnswersByQuestionId(question.getId());
//        System.out.println(answers);
//        QuestionOutput questionOutput = new QuestionOutput(question, answers);
//        questionOutputList.add(questionOutput);
//      }
//      QuestionGroupOutput questionGroupOutput = new QuestionGroupOutput(questionGroup, questionOutputList);
//      questionGroupOutputList.add(questionGroupOutput);
//    }
//    return new PartWithQuestionGroupOutput(part, questionGroupOutputList);
//  }
//
//  @Override
//  public TestOutput generateTest(int testId) {
//    Test test = toeicTestRetriveRepository.queryTestById(testId);
//    System.out.println(test);
//    PartWithQuestionOutput part1 = generatePartWithQuestionOutput(testId, 1);
//    PartWithQuestionOutput part2 = generatePartWithQuestionOutput(testId, 2);
//    PartWithQuestionOutput part3 = generatePartWithQuestionOutput(testId, 3);
//    PartWithQuestionOutput part4 = generatePartWithQuestionOutput(testId, 4);
//    PartWithQuestionOutput part5 = generatePartWithQuestionOutput(testId, 5);
//    PartWithQuestionGroupOutput part6 = generatePartWithQuestionGroupOutput(testId, 6);
//    PartWithQuestionGroupOutput part7 = generatePartWithQuestionGroupOutput(testId, 7);
//    TestOutput testOutput = new TestOutput(test, part1, part2, part3, part4, part5, part6, part7);
//    return testOutput;
//  }

  private Part generatePartWithOnlyQuestions(int testId, int partNum, boolean shuffleQuestionsFlag, boolean shuffleAnswersFlag) {
    Part part = toeicTestRetriveRepository.queryPartByTestIdAndPartNum(testId, partNum);
    List<Question> questions = toeicTestRetriveRepository.queryQuestionsByPartId(part.getId());
    part.setQuestions(shuffleQuestionsWithAnswers(questions, shuffleQuestionsFlag, shuffleAnswersFlag));
    return part;
  }

  private Part generatePartWithQuestionGroups(int testId, int partNum, boolean shuffleQuestionGroupsFlag, boolean shuffleQuestionsFlag, boolean shuffleAnswersFlag) {
    Part part = toeicTestRetriveRepository.queryPartByTestIdAndPartNum(testId, partNum);
    List<QuestionGroup> questionGroups = toeicTestRetriveRepository.queryGroupsByPartId(part.getId());
    if(shuffleQuestionGroupsFlag) {
      Collections.shuffle(questionGroups);
    }
    for(QuestionGroup questionGroup: questionGroups) {
      List<Question> questions = toeicTestRetriveRepository.queryQuestionsByGroupId(questionGroup.getId());
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
      List<Answer> answers = toeicTestRetriveRepository.queryAnswersByQuestionId(question.getId());
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
    Test test = toeicTestRetriveRepository.queryTestById(testId);
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
  public TestInfor getTestInfor() {
    return new TestInfor(120*60, 200);
  }
}
