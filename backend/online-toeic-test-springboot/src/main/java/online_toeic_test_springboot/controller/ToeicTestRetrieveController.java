package online_toeic_test_springboot.controller;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.*;
import online_toeic_test_springboot.service.ToeicTestRetrieveService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ToeicTestRetrieveController {

  private final ToeicTestRetrieveService toeicTestRetrieveService;

  @GetMapping("/tests")
  public ResponseEntity<List<Test>> getTests() {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getAllTests());
  }

  @GetMapping("/tests/{id}")
  public ResponseEntity<Test> getTestById(@PathVariable Integer id) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getTestById(id));
  }

  @GetMapping("/parts")
  public ResponseEntity<List<Part>> getParts(@RequestParam(required = false) Integer testId) {
    List<Part> parts = null;
    if(testId == null) {
      parts = toeicTestRetrieveService.getAllParts();
    } else {
      parts = toeicTestRetrieveService.getPartsByTestId(testId);
    }
    return ResponseEntity.ok().body(parts);
  }

  @GetMapping("/questions")
  public ResponseEntity<List<Question>> getQuestions(@RequestParam(required = false) Integer partId, @RequestParam(required = false) Integer groupId) {
    List<Question> questions = null;
    if(partId == null && groupId == null) {
      questions = toeicTestRetrieveService.getAllQuestions();
    }
    if(partId != null && groupId == null) {
      questions = toeicTestRetrieveService.getQuestionsByPartId(partId);
    }
    if(partId == null && groupId != null) {
      questions = toeicTestRetrieveService.getQuestionsByGroupId(groupId);
    }
    return ResponseEntity.ok().body(questions);
  }

  @GetMapping("/question-groups")
  public ResponseEntity<List<QuestionGroup>> getQuestionGroups(@RequestParam(required = false) Integer partId) {
    List<QuestionGroup> questionGroups = null;
    if(partId == null) {
      questionGroups = toeicTestRetrieveService.getAllQuestionGroups();
    } else {
      questionGroups = toeicTestRetrieveService.getQuestionGroupsByPartId(partId);
    }
    return ResponseEntity.ok().body(questionGroups);
  }

  @GetMapping("/answers")
  public ResponseEntity<List<Answer>> getAnswers(@RequestParam(required = false) Integer questionId) {
    List<Answer> answers = null;
    if(questionId == null) {
      answers = toeicTestRetrieveService.getAllAnswers();
    } else {
      answers = toeicTestRetrieveService.getAnswersByQuestionId(questionId);
    }
    return ResponseEntity.ok().body(answers);
  }

  @GetMapping("/question-groups/{id}")
  public ResponseEntity<QuestionGroup> getQuestionGroupById(@PathVariable Integer id) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getQuestionGroupById(id));
  }

  @GetMapping("/questions/{id}")
  public ResponseEntity<Question> getQuestionById(@PathVariable Integer id) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getQuestionById(id));
  }

  @GetMapping("/parts/{id}")
  public ResponseEntity<Part> getPartById(@PathVariable Integer id) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getPartById(id));
  }

  @GetMapping("/generate-test/{id}")
  public ResponseEntity<Test> generateTest(@PathVariable Integer id) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.retrieveTestByIdAndShuffle(id));
  }

  @GetMapping("/generate-test-achievement/{achievementId}")
  public ResponseEntity<Test> generateTestByAchievementId(@PathVariable Integer achievementId) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.retrieveTestByAchievementIdAndShuffle(achievementId));
  }

  @GetMapping("/achievements")
  public ResponseEntity<List<Achievement>> getAchievements(@RequestParam(required = false) Integer examineeId) {
    List<Achievement> achivements = null;
    if(examineeId == null) {
      achivements = toeicTestRetrieveService.getAllAchievements();
    } else {
      achivements = toeicTestRetrieveService.getAchievementsByExamineeId(examineeId);
    }
    return ResponseEntity.ok().body(achivements);
  }

  @GetMapping("/achievements/{id}")
  public ResponseEntity<Achievement> getAchievementById(@PathVariable Integer id) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getAchievementById(id));
  }

  @GetMapping("/examinee-answers")
  public ResponseEntity<List<ExamineeAnswer>> getExamineeAnswers() {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getAllExamineeAnswers());
  }

  @GetMapping("/test-information/{testId}")
  public ResponseEntity<TestInfor> getTestInfor(@PathVariable Integer testId) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getTestInfor(testId));
  }
}
