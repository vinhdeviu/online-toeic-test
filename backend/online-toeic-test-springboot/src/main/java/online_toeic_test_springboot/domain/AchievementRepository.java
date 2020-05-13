package online_toeic_test_springboot.domain;

import java.util.List;

public interface AchievementRepository {

    void createAchievement(Achievement achievement);

    List<Achievement> getAchievementByExamineeId(int examineeId);

    Achievement getAchievementById(int id);
}
