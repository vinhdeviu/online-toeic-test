package online_toeic_test_springboot.web;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.service.AllPartsOutput;
import online_toeic_test_springboot.service.Part1Output;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ToeicTestRetrieveController.
 */
@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ToeicTestRetrieveController {

  //private final ToeicTestRetrieveService toeicTestRetrieveService;

  @GetMapping("/all-parts")
  public ResponseEntity<AllPartsOutput> handle() {
    Part1Output part1Output = new Part1Output("vinh", null);
    return ResponseEntity.ok().body(new AllPartsOutput(part1Output, null, null, null, null, null, null));
  }
}
