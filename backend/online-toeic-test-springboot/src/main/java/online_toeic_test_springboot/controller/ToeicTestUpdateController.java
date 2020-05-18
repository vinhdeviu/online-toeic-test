package online_toeic_test_springboot.controller;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.Part;
import online_toeic_test_springboot.domain.model.Question;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;
import online_toeic_test_springboot.service.ToeicTestUpdateService;
import online_toeic_test_springboot.validation.RequestBodyValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ToeicTestUpdateController {

  private final ToeicTestUpdateService toeicTestUpdateService;

  private final RequestBodyValidation requestBodyValidation;

  @PatchMapping("/tests/{id}")
  public ResponseEntity<Test> updateTest(@PathVariable Integer id, @RequestBody Test test) {
    test.setId(id);
    toeicTestUpdateService.updateTest(test);
    return ResponseEntity.ok().body(test);
  }

  @PatchMapping("/parts/{id}")
  public ResponseEntity<Part> updatePart(@PathVariable Integer id, @RequestBody Part part) {
    part.setId(id);
    toeicTestUpdateService.updatePart(part);
    return ResponseEntity.ok().body(part);
  }

  @PatchMapping("/question-groups/{id}")
  public ResponseEntity<QuestionGroup> updateQuestionGroup(@PathVariable Integer id, @RequestBody QuestionGroup questionGroup) {
    questionGroup.setId(id);
    toeicTestUpdateService.updateQuestionGroup(questionGroup);
    return ResponseEntity.ok().body(questionGroup);
  }

  @PatchMapping("/questions/{id}")
  public ResponseEntity<Question> updateQuestion(@PathVariable Integer id, @RequestBody Question question) {
    question.setId(id);
    toeicTestUpdateService.updateQuestion(question);
    return ResponseEntity.ok().body(question);
  }
}
