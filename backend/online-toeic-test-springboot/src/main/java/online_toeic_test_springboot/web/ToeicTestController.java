package online_toeic_test_springboot.web;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.Test;
import online_toeic_test_springboot.domain.TestInfor;
import online_toeic_test_springboot.service.PartOutput;
import online_toeic_test_springboot.service.TestOutput;
import online_toeic_test_springboot.service.ToeicTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ToeicTestController {

  private final ToeicTestService toeicTestService;

//  @GetMapping("/generate-test/{id}")
//  public ResponseEntity<TestOutput> generateTest(@PathVariable int id) {
//    TestOutput testOutput = toeicTestService.generateTest(id);
//    return ResponseEntity.ok().body(testOutput);
//  }

  @GetMapping("/tests")
  public ResponseEntity<List<Test>> getAllTests() {
    List<Test> tests = toeicTestService.retrieveAllTests();
    return ResponseEntity.ok().body(tests);
  }

  @GetMapping("/generate-test/{id}")
  public ResponseEntity<Test> generateTest(@PathVariable int id) {
    Test test = toeicTestService.generateTest(id);
    return ResponseEntity.ok().body(test);
  }

  @GetMapping("/test-information")
  public ResponseEntity<TestInfor> getTestInfor() {
    return ResponseEntity.ok().body(toeicTestService.getTestInfor());
  }
}
