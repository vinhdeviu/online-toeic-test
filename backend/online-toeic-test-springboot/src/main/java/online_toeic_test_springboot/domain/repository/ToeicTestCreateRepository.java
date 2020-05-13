package online_toeic_test_springboot.domain.repository;

import online_toeic_test_springboot.domain.model.Achievement;

public interface ToeicTestCreateRepository {

    void createAchievement(Achievement achievement);
}
