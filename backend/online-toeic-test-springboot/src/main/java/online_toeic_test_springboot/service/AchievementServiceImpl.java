package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {

  @Autowired
  private final AchievementRepository achievementRepository;

  @Override
  public void createAchievement(Achievement achievement) {
    achievementRepository.createAchievement(achievement);
  }

  @Override
  public List<Achievement> getAchievementByExamineeId(int examineeId) {
    return achievementRepository.getAchievementByExamineeId(examineeId);
  }
}
