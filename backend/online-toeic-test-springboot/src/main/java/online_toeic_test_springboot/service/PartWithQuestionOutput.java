package online_toeic_test_springboot.service;

import lombok.Data;
import online_toeic_test_springboot.domain.Part;
import online_toeic_test_springboot.domain.Question;

import java.util.List;

@Data
public class PartWithQuestionOutput {
    private Part part;
    private List<Question> questions;

    public PartWithQuestionOutput(Part part, List<Question> questions) {
        this.part = part;
        this.questions = questions;
    }
}
