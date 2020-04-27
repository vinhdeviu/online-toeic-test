package online_toeic_test_springboot.service;

import lombok.Data;
import lombok.EqualsAndHashCode;
import online_toeic_test_springboot.domain.Part;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class PartWithQuestionGroupOutput extends PartOutput {
    private List<QuestionGroupOutput> questionGroupOutputList;

    public PartWithQuestionGroupOutput(Part part, List<QuestionGroupOutput> questionGroupOutputList) {
        this.part = part;
        this.questionGroupOutputList = questionGroupOutputList;
    }
}
