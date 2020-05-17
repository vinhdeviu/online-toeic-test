package online_toeic_test_springboot.controller;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.Achievement;
import online_toeic_test_springboot.domain.model.Question;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;
import online_toeic_test_springboot.service.ToeicTestCreateService;
import online_toeic_test_springboot.validation.RequestBodyValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ToeicTestCreateController {

  private final ToeicTestCreateService toeicTestCreateService;

  private final RequestBodyValidation requestBodyValidation;

  @PostMapping("/achievements")
  public ResponseEntity<Achievement> createArchivement(@RequestBody Achievement achievement) throws URISyntaxException {
    System.out.println(achievement);
    toeicTestCreateService.createAchievement(achievement);
    return ResponseEntity.created(new URI("/api/achievements")).body(achievement);
  }

  @PostMapping("/tests")
  public ResponseEntity<Test> createNewToeicTest(@RequestBody Test test) throws URISyntaxException {
    requestBodyValidation.validateTest(test);
    toeicTestCreateService.createNewToeicTest(test);
    return ResponseEntity.created(new URI("/api/tests")).body(test);
  }

  @PostMapping("/question-groups")
  public ResponseEntity<QuestionGroup> createNewToeicTest(@RequestBody QuestionGroup questionGroup) throws URISyntaxException {
    System.out.println(questionGroup);
    toeicTestCreateService.createNewQuestionGroup(questionGroup);
    return ResponseEntity.created(new URI("/api/question-groups")).body(questionGroup);
  }

  @PostMapping("/questions")
  public ResponseEntity<Question> createNewToeicTest(@RequestBody Question question) throws URISyntaxException {
    System.out.println(question);
    toeicTestCreateService.createNewQuestion(question);
    return ResponseEntity.created(new URI("/api/questions")).body(question);
  }
}
