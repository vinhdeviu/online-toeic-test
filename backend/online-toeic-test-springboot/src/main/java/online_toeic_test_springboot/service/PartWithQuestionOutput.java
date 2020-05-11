package online_toeic_test_springboot.service;

import lombok.Data;
import lombok.EqualsAndHashCode;
import online_toeic_test_springboot.domain.Part;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class PartWithQuestionOutput extends PartOutput {
    private List<QuestionOutput> questions;

    public PartWithQuestionOutput(Part part, List<QuestionOutput> questions) {
        this.part = part;
        this.questions = questions;
    }
}
