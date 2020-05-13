package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.Achievement;
import online_toeic_test_springboot.domain.repository.ToeicTestCreateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ToeicTestCreateServiceImpl implements ToeicTestCreateService {

  @Autowired
  private final ToeicTestCreateRepository toeicTestCreateRepository;

  @Override
  public void createAchievement(Achievement achievement) {
    toeicTestCreateRepository.createAchievement(achievement);
  }
}
