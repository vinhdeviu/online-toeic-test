package online_toeic_test_springboot.controller;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.Achievement;
import online_toeic_test_springboot.domain.model.Part;
import online_toeic_test_springboot.domain.model.Test;
import online_toeic_test_springboot.domain.model.TestInfor;
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
  public ResponseEntity<List<Test>> getAllTests() {
    return ResponseEntity.ok().body(toeicTestRetrieveService.retrieveAllTests());
  }

  @GetMapping("/tests/{id}")
  public ResponseEntity<Test> getTestById(@PathVariable int id) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getTestById(id));
  }

  @GetMapping("/parts")
  public ResponseEntity<List<Part>> getPartsByTestId(@RequestParam int testId) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getPartsByTestId(testId));
  }

  @GetMapping("/generate-test/{id}")
  public ResponseEntity<Test> generateTest(@PathVariable int id) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.retrieveTestByIdAndShuffle(id));
  }

  @GetMapping("/generate-test-achievement/{achievementId}")
  public ResponseEntity<Test> generateTestByAchievementId(@PathVariable int achievementId) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.retrieveTestByAchievementIdAndShuffle(achievementId));
  }

  @GetMapping("/achievements")
  public ResponseEntity<List<Achievement>> getAchievementsByExamineeId(@RequestParam int examineeId) {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getAchievementByExamineeId(examineeId));
  }

  @GetMapping("/test-information")
  public ResponseEntity<TestInfor> getTestInfor() {
    return ResponseEntity.ok().body(toeicTestRetrieveService.getTestInfor());
  }
}
