package online_toeic_test_springboot.controller;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.Part;
import online_toeic_test_springboot.domain.model.Question;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;
import online_toeic_test_springboot.service.ToeicTestReplaceService;
import online_toeic_test_springboot.domain.model.HttpMethod;
import online_toeic_test_springboot.validation.RequestBodyValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ToeicTestReplaceController {

  private final ToeicTestReplaceService toeicTesttReplaceService;

  private final RequestBodyValidation requestBodyValidation;

  @PutMapping("/tests/{id}")
  public ResponseEntity<Test> replaceTest(@PathVariable Integer id, @RequestBody Test test) {
    test.setId(id);
    requestBodyValidation.validateTest(test, HttpMethod.PUT);
    toeicTesttReplaceService.replaceTest(test);
    return ResponseEntity.ok().body(test);
  }

  @PutMapping("/parts/{id}")
  public ResponseEntity<Part> replacePart(@PathVariable Integer id, @RequestBody Part part) {
    part.setId(id);
    requestBodyValidation.validatePart(part, HttpMethod.PUT);
    toeicTesttReplaceService.replacePart(part);
    return ResponseEntity.ok().body(part);
  }

  @PutMapping("/question-groups/{id}")
  public ResponseEntity<QuestionGroup> replaceQuestionGroup(@PathVariable Integer id, @RequestBody QuestionGroup questionGroup) {
    questionGroup.setId(id);
    requestBodyValidation.validateQuestionGroup(questionGroup, HttpMethod.PUT);
    toeicTesttReplaceService.replaceQuestionGroup(questionGroup);
    return ResponseEntity.ok().body(questionGroup);
  }

  @PutMapping("/questions/{id}")
  public ResponseEntity<Question> replaceQuestion(@PathVariable Integer id, @RequestBody Question question) {
    question.setId(id);
    requestBodyValidation.validateQuestion(question, HttpMethod.PUT);
    toeicTesttReplaceService.replaceQuestion(question);
    return ResponseEntity.ok().body(question);
  }
}
