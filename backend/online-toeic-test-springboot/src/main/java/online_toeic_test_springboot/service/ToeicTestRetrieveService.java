package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.model.Achievement;
import online_toeic_test_springboot.domain.model.Test;
import online_toeic_test_springboot.domain.model.TestInfor;

import java.util.List;

public interface ToeicTestRetrieveService {

    List<Test> retrieveAllTests();

    Test retrieveTestByIdAndShuffle(int testId);

    Test retrieveTestByAchievementIdAndShuffle(int achievementId);

    List<Achievement> getAchievementByExamineeId(int examineeId);

    TestInfor getTestInfor();
}
