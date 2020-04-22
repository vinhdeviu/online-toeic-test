package online_toeic_test_springboot.web;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.service.PartWithQuestionOutput;
import online_toeic_test_springboot.service.ToeicTestRetrieveService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ToeicTestRetrieveController {

  private final ToeicTestRetrieveService toeicTestRetrieveService;

  @GetMapping("/parts/1")
  public ResponseEntity<PartWithQuestionOutput> retrievePart1() {
    PartWithQuestionOutput part1Output = toeicTestRetrieveService.retrievePart1();
    return ResponseEntity.ok().body(part1Output);
  }
}
