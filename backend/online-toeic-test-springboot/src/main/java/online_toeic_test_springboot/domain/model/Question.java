package online_toeic_test_springboot.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class Question {
    private Integer id;
    private Integer partId;
    private Integer groupId;
    private Integer index;
    private String imageLink;
    private String questionTittle;
    private Character correctAnswer;
    private Integer correctAnswerId;
    private Integer questionNo;
    private Map<Character, Answer> answers;
}
