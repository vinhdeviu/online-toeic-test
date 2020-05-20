package online_toeic_test_springboot.controller;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.service.ToeicTestDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ToeicTestDeleteController {

  private final ToeicTestDeleteService toeicTestDeleteService;

  @DeleteMapping("/tests/{id}")
  public ResponseEntity<?> deleteTestById(@PathVariable Integer id) {
    toeicTestDeleteService.deleteTestById(id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/parts/{id}")
  public ResponseEntity<?> deletePartById(@PathVariable Integer id) {
    toeicTestDeleteService.deletePartById(id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/question-groups/{id}")
  public ResponseEntity<?> deleteQuestionGroupById(@PathVariable Integer id) {
    toeicTestDeleteService.deleteQuestionGroupById(id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/questions/{id}")
  public ResponseEntity<?> deleteQuestionById(@PathVariable Integer id) {
    toeicTestDeleteService.deleteQuestionById(id);
    return ResponseEntity.noContent().build();
  }
}
