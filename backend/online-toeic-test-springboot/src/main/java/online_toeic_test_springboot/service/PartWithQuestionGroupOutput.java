package online_toeic_test_springboot.service;

import lombok.Data;
import online_toeic_test_springboot.domain.Part;

@Data
public class PartWithQuestionGroupOutput {
    private Part part;
    private QuestionGroupOutput questionGroup;
}
