package online_toeic_test_springboot.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import online_toeic_test_springboot.domain.Answer;
import online_toeic_test_springboot.domain.Question;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionOutput {
    private Question question;
    private List<Answer> answers;
}
