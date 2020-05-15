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
    return ResponseEntity.ok().body(toeicTestRetrieveService.retrieveAllTests());
  }

  @GetMapping("/tests/{id}")
  public ResponseEntity<Test> getTestById(@PathVariable Integer id) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getTestById(id));
  }

  @GetMapping("/parts")
  public ResponseEntity<List<Part>> getParts(@RequestParam(required = false) Integer testId) {
    if(testId == null) {
      // get all parts
    }
    return ResponseEntity.ok().body(toeicTestRetrieveService.getPartsByTestId(testId));
  }

  @GetMapping("/questions")
  public ResponseEntity<List<Question>> getQuestions(@RequestParam(required = false) Integer partId, @RequestParam(required = false) Integer groupId) {
    List<Question> questions = null;
    if(partId == null && groupId == null) {
      // get all questions
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
    if(partId == null) {
      // get all questions
    }
    return ResponseEntity.ok().body(toeicTestRetrieveService.getQuestionGroupsByPartId(partId));
  }

  @GetMapping("/question-groups/{id}")
  public ResponseEntity<QuestionGroup> getQuestionGroupById(@PathVariable Integer id) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getQuestionGroupById(id));
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
    if(examineeId == null) {
      // get all achievements
    }
    return ResponseEntity.ok().body(toeicTestRetrieveService.getAchievementByExamineeId(examineeId));
  }

  @GetMapping("/test-information")
  public ResponseEntity<TestInfor> getTestInfor() {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getTestInfor());
  }
}
