package online_toeic_test_springboot.domain;

import java.util.List;
import java.util.Optional;

public interface ToeicTestRetriveRepository {

    Optional<Part> getPartById(int id);

    List<Question> queryQuestionsByPartId(int partId);
}
