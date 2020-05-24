package online_toeic_test_springboot.controller;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.Achievement;
import online_toeic_test_springboot.domain.model.Question;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;
import online_toeic_test_springboot.service.ToeicTestCreateService;
import online_toeic_test_springboot.domain.model.HttpMethod;
import online_toeic_test_springboot.validation.RequestBodyValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
  public ResponseEntity<Achievement> createAchievement(@RequestBody Achievement achievement, final UriComponentsBuilder builder) throws URISyntaxException {
    requestBodyValidation.validateAchievement(achievement, HttpMethod.POST);
    toeicTestCreateService.createAchievement(achievement);
    final URI location = builder
        .path("achievements/{id}")
        .buildAndExpand(achievement.getId())
        .encode()
        .toUri();
    return ResponseEntity.created(location).body(achievement);
  }

  @PostMapping("/tests")
  public ResponseEntity<Test> createNewToeicTest(@RequestBody Test test, final UriComponentsBuilder builder) throws URISyntaxException {
    requestBodyValidation.validateTest(test, HttpMethod.POST);
    toeicTestCreateService.createNewToeicTest(test);
    final URI location = builder
        .path("tests/{id}")
        .buildAndExpand(test.getId())
        .encode()
        .toUri();
    return ResponseEntity.created(location).body(test);
  }

  @PostMapping("/question-groups")
  public ResponseEntity<QuestionGroup> createNewQuestionGroup(@RequestBody QuestionGroup questionGroup, final UriComponentsBuilder builder) throws URISyntaxException {
    requestBodyValidation.validateQuestionGroup(questionGroup, HttpMethod.POST);
    toeicTestCreateService.createNewQuestionGroup(questionGroup);
    final URI location = builder
        .path("question-groups/{id}")
        .buildAndExpand(questionGroup.getId())
        .encode()
        .toUri();
    return ResponseEntity.created(location).body(questionGroup);
  }

  @PostMapping("/questions")
  public ResponseEntity<Question> createNewQuestion(@RequestBody Question question, final UriComponentsBuilder builder) throws URISyntaxException {
    requestBodyValidation.validateQuestion(question, HttpMethod.POST);
    toeicTestCreateService.createNewQuestion(question);
    final URI location = builder
        .path("questions/{id}")
        .buildAndExpand(question.getId())
        .encode()
        .toUri();
    return ResponseEntity.created(location).body(question);
  }
}