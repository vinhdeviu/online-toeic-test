package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.Part;
import online_toeic_test_springboot.domain.model.Question;
import online_toeic_test_springboot.domain.model.QuestionGroup;
import online_toeic_test_springboot.domain.model.Test;
import online_toeic_test_springboot.domain.repository.ToeicTestReplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ToeicTestReplaceServiceImpl implements ToeicTestReplaceService {

  @Autowired
  private final ToeicTestReplaceRepository toeicTestReplaceRepository;

  @Override
  public void replaceTest(Test test) {
    toeicTestReplaceRepository.replaceTest(test);
  }

  @Override
  public void replacePart(Part part) {
    toeicTestReplaceRepository.replacePart(part);
  }

  @Override
  public void replaceQuestionGroup(QuestionGroup questionGroup) {
    toeicTestReplaceRepository.replaceQuestionGroup(questionGroup);
  }

  @Override
  public void replaceQuestion(Question question) {
    toeicTestReplaceRepository.replaceQuestion(question);
  }
}
