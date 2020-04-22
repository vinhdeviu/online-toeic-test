package online_toeic_test_springboot.data;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.Part;
import online_toeic_test_springboot.domain.Question;
import online_toeic_test_springboot.domain.ToeicTestRetriveRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class MyBatisToeicTestRetriveRepository implements ToeicTestRetriveRepository {

  private final ToeicTestRetriveMapper toeicTestRetriveMapper;

  public Optional<Part> getPartById(int id) {
    return this.toeicTestRetriveMapper.queryPartById(id);
  }

  public List<Question> queryQuestionsByPartId(int partId) {
    return this.toeicTestRetriveMapper.queryQuestionsByPartId(partId);
  }
}
