package online_toeic_test_springboot.web;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.TestInfor;
import online_toeic_test_springboot.service.PartOutput;
import online_toeic_test_springboot.service.ToeicTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ToeicTestController {

  private final ToeicTestService toeicTestService;

  @GetMapping("/generate-part/{id}")
  public ResponseEntity<PartOutput> generatePart(
      @PathVariable int id,
      @RequestParam(required = false, defaultValue = "1") int difficulty) {
    PartOutput partOutput = toeicTestService.generatePart(id, difficulty);
    return ResponseEntity.ok().body(partOutput);
  }

  @GetMapping("/test-information")
  public ResponseEntity<TestInfor> getTestInfor() {
    return ResponseEntity.ok().body(toeicTestService.getTestInfor());
  }
}
