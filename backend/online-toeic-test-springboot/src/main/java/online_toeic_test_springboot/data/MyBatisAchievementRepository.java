package online_toeic_test_springboot.data;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.*;
import online_toeic_test_springboot.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class MyBatisAchievementRepository implements AchievementRepository {

  private final AchievementMapper achievementMapper;

  @Override
  public void createAchievement(Achievement achievement) {
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    achievement.setDate(dateFormat.format(date));
    achievementMapper.insertAchievement(achievement);
    for(ExamineeAnswer examineeAnswer: achievement.getExamineeAnswers()) {
      if(examineeAnswer == null) continue;
      examineeAnswer.setAchievementId(achievement.getId());
      achievementMapper.insertExamineeAnswer(examineeAnswer);
    }
  }

  @Override
  public List<Achievement> getAchievementByExamineeId(int examineeId) {
    return achievementMapper.queryAchievementByExamineeId(examineeId);
  }

  @Override
  public Achievement getAchievementById(int id) {
    Optional<Achievement> optionalAchievement = achievementMapper.queryAchievementById(id);
    if(!optionalAchievement.isPresent()) {
      throw new EntityNotFoundException("achievement not found");
    }
    Achievement achievement = optionalAchievement.get();
    achievement.setExamineeAnswers(achievementMapper.queryExamineeAnswersByAchievementId(achievement.getId()));
    return achievement;
  }
}
