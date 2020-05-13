package online_toeic_test_springboot.web;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.Achievement;
import online_toeic_test_springboot.service.ToeicTestCreateService;
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

  @PostMapping("/achievements")
  public ResponseEntity<?> createArchivement(@RequestBody Achievement achievement) throws URISyntaxException {
    System.out.println(achievement);
    toeicTestCreateService.createAchievement(achievement);
    return ResponseEntity.created(new URI("/api/achievements")).body("Achievements Created Successfully");
  }
}
