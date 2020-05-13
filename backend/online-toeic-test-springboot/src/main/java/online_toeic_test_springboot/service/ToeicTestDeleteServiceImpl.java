package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.Part;
import online_toeic_test_springboot.domain.model.Question;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;
import online_toeic_test_springboot.domain.repository.ToeicTestDeleteRepository;
import online_toeic_test_springboot.domain.repository.ToeicTestUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ToeicTestDeleteServiceImpl implements ToeicTestDeleteService {

  @Autowired
  private final ToeicTestDeleteRepository toeicTestDeleteRepository;

  @Override
  public void deleteTestById(int id) {
    toeicTestDeleteRepository.deleteTestById(id);
  }

  @Override
  public void deletePartById(int id) {
    toeicTestDeleteRepository.deletePartById(id);
  }

  @Override
  public void deleteQuestionGroupById(int id) {
    toeicTestDeleteRepository.deleteQuestionGroupById(id);
  }

  @Override
  public void deleteQuestionById(int id) {
    toeicTestDeleteRepository.deleteQuestionById(id);
  }
}
