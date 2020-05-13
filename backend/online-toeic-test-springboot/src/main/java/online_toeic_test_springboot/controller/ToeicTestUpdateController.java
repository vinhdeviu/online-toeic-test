package online_toeic_test_springboot.controller;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.Part;
import online_toeic_test_springboot.domain.model.Question;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;
import online_toeic_test_springboot.service.ToeicTestUpdateService;
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

  @PatchMapping("/tests/{id}")
  public ResponseEntity<Test> updateTest(@PathVariable int id, @RequestBody Test test) {
    test.setId(id);
    System.out.println(test);
    toeicTestUpdateService.updateTest(test);
    return ResponseEntity.ok().body(test);
  }

  @PatchMapping("/parts/{id}")
  public ResponseEntity<Part> updatePart(@PathVariable int id, @RequestBody Part part) {
    part.setId(id);
    System.out.println(part);
    toeicTestUpdateService.updatePart(part);
    return ResponseEntity.ok().body(part);
  }

  @PatchMapping("/question-groups/{id}")
  public ResponseEntity<QuestionGroup> updateQuestionGroup(@PathVariable int id, @RequestBody QuestionGroup questionGroup) {
    questionGroup.setId(id);
    System.out.println(questionGroup);
    toeicTestUpdateService.updateQuestionGroup(questionGroup);
    return ResponseEntity.ok().body(questionGroup);
  }

  @PatchMapping("/questions")
  public ResponseEntity<Question> updateQuestion(@PathVariable int id, @RequestBody Question question) {
    question.setId(id);
    System.out.println(question);
    toeicTestUpdateService.updateQuestion(question);
    return ResponseEntity.ok().body(question);
  }
}
