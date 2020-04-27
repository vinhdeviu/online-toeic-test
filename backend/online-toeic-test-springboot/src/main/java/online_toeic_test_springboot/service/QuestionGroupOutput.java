package online_toeic_test_springboot.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import online_toeic_test_springboot.domain.Question;
import online_toeic_test_springboot.domain.QuestionGroup;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionGroupOutput {
    private QuestionGroup questionGroup;
    private List<Question> questions;
}
