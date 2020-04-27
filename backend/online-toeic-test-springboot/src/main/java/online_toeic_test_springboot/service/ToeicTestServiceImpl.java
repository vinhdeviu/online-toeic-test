package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.*;
import online_toeic_test_springboot.exception.EntityNotFoundException;
import online_toeic_test_springboot.exception.PartIdNotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ToeicTestServiceImpl implements ToeicTestService {

  @Autowired
  private final ToeicTestRetriveRepository toeicTestRetriveRepository;

  @Override
  public PartOutput generatePart(int partId, int difficulty) {
    Optional<Part> part = toeicTestRetriveRepository.getPartById(partId);
    if(!part.isPresent()) { throw new EntityNotFoundException(partId + " does not exist"); }
    int numRandomGroup;
    int numRandomQuestion;
    switch (partId) {
      case 1: numRandomQuestion = 4; numRandomGroup = 0; break;
      case 2: numRandomQuestion = 4; numRandomGroup = 0; break;
      case 3: numRandomQuestion = 3; numRandomGroup = 2; break;
      case 4: numRandomQuestion = 3; numRandomGroup = 2; break;
      case 5: numRandomQuestion = 6; numRandomGroup = 0; break;
      case 6: numRandomQuestion = 4; numRandomGroup = 1; break;
      case 7: numRandomQuestion = 5; numRandomGroup = 2; break;
      default: throw new PartIdNotImplementedException(partId + " is not implemented yet");
    }
    PartOutput partOutput;
    if(numRandomGroup == 0) {
      List<Question> questions = toeicTestRetriveRepository.queryRandomQuestionsByPartIdAndDifficulty(partId, difficulty, numRandomQuestion);
      partOutput = new PartWithQuestionOutput(part.get(), questions);
    } else {
      List<QuestionGroup> questionGroups = toeicTestRetriveRepository.queryRandomGroupsByPartIdAndDifficulty(partId, difficulty, numRandomGroup);
      List<QuestionGroupOutput> questionGroupOutputList = new ArrayList<>();
      for(QuestionGroup questionGroup: questionGroups) {
        List<Question> questions = toeicTestRetriveRepository.queryRandomQuestionsByGroupId(questionGroup.getId(), numRandomQuestion);
        QuestionGroupOutput questionGroupOutput = new QuestionGroupOutput(questionGroup, questions);
        questionGroupOutputList.add(questionGroupOutput);
      }
      partOutput = new PartWithQuestionGroupOutput(part.get(), questionGroupOutputList);
    }
    return partOutput;
  }

  @Override
  public TestInfor getTestInfor() {
    return new TestInfor(1200, 40);
  }
}
