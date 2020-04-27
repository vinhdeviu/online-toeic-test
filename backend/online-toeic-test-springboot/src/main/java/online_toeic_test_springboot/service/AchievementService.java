package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.Achievement;

import java.util.List;

public interface AchievementService {

    void createAchievement(Achievement achievement);

    List<Achievement> getAchievementByExamineeId(int examineeId);
}
