package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.Part;
import online_toeic_test_springboot.domain.Question;
import online_toeic_test_springboot.domain.ToeicTestRetriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ToeicTestRetrieveServiceImpl implements ToeicTestRetrieveService {

  @Autowired
  private final ToeicTestRetriveRepository toeicTestRetriveRepository;

  public PartWithQuestionOutput retrievePart1() {
    Optional<Part> part1 = toeicTestRetriveRepository.getPartById(1);
    if(!part1.isPresent()) {
      return null;
    }
    List<Question> questionsPart1 = toeicTestRetriveRepository.queryQuestionsByPartId(1);
    PartWithQuestionOutput part1Output = new PartWithQuestionOutput(part1.get(), questionsPart1);
    return part1Output;
  }
}
