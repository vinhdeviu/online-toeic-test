package online_toeic_test_springboot.data.repository;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.data.mapper.AchievementCRUDMapper;
import online_toeic_test_springboot.data.mapper.ExamineeAnswerCRUDMapper;
import online_toeic_test_springboot.domain.model.Achievement;
import online_toeic_test_springboot.domain.model.ExamineeAnswer;
import online_toeic_test_springboot.domain.repository.ToeicTestCreateRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Repository
@Transactional
@RequiredArgsConstructor
public class MyBatisToeicTestCreateRepository implements ToeicTestCreateRepository {

  private final AchievementCRUDMapper achievementCRUDMapper;

  private final ExamineeAnswerCRUDMapper examineeAnswerCRUDMapper;

  @Override
  public void createAchievement(Achievement achievement) {
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    achievement.setDate(dateFormat.format(date));
    achievementCRUDMapper.insertAchievement(achievement);
    for(ExamineeAnswer examineeAnswer: achievement.getExamineeAnswers()) {
      if(examineeAnswer == null) continue;
      examineeAnswer.setAchievementId(achievement.getId());
      examineeAnswerCRUDMapper.insertExamineeAnswer(examineeAnswer);
    }
  }
}
