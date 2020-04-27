package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {

  @Autowired
  private final AchievementRepository achievementRepository;

  @Override
  public void createAchievement(Achievement achievement) {
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    achievement.setDate(dateFormat.format(date));
    achievementRepository.createAchievement(achievement);
  }

  @Override
  public List<Achievement> getAchievementByExamineeId(int examineeId) {
    return achievementRepository.getAchievementByExamineeId(examineeId);
  }
}
