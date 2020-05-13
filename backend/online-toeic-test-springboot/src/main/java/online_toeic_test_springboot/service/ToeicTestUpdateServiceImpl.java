package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.*;
import online_toeic_test_springboot.domain.repository.ToeicTestUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ToeicTestUpdateServiceImpl implements ToeicTestUpdateService {

  @Autowired
  private final ToeicTestUpdateRepository toeicTestUpdateRepository;

  @Override
  public void updateTest(Test test) {
    toeicTestUpdateRepository.updateTest(test);
  }

  @Override
  public void updatePart(Part part) {
    toeicTestUpdateRepository.updatePart(part);
  }

  @Override
  public void updateQuestionGroup(QuestionGroup questionGroup) {
    toeicTestUpdateRepository.updateQuestionGroup(questionGroup);
  }

  @Override
  public void updateQuestion(Question question) {
    toeicTestUpdateRepository.updateQuestion(question);
  }
}
