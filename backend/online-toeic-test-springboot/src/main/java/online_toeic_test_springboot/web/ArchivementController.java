package online_toeic_test_springboot.web;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.Achievement;
import online_toeic_test_springboot.domain.TestInfor;
import online_toeic_test_springboot.service.AchievementService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ArchivementController {

  private final AchievementService achievementService;

  @PostMapping("/achievements")
  public ResponseEntity<?> createArchivement(@RequestBody Achievement achievement) throws URISyntaxException {
    achievementService.createAchievement(achievement);
    return ResponseEntity.created(new URI("/api/achievements")).body("Achievements Created Successfully");
  }

  @GetMapping("/achievements/{examineeId}")
  public ResponseEntity<List<Achievement>> getAchievementByExamineeId(@PathVariable int examineeId) {
    return ResponseEntity.ok().body(achievementService.getAchievementByExamineeId(examineeId));
  }
}
