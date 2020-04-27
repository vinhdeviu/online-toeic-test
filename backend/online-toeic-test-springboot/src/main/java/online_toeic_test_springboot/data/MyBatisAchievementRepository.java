package online_toeic_test_springboot.data;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class MyBatisAchievementRepository implements AchievementRepository {

  private final AchievementMapper achievementMapper;

  @Override
  public void createAchievement(Achievement achievement) {
    achievementMapper.createAchievement(achievement);
  }

  @Override
  public List<Achievement> getAchievementByExamineeId(int examineeId) {
    return achievementMapper.getAchievementByExamineeId(examineeId);
  }
}
