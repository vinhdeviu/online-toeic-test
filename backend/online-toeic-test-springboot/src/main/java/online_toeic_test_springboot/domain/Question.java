package online_toeic_test_springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Question {
    private int id;
    private int partId;
    private int groupId;
    private String imageLink;
    private String audioLink;
    private int difficulty;
    private String questionTittle;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private char answer;
}
