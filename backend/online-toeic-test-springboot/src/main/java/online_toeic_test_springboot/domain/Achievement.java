package online_toeic_test_springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Achievement {
    private int id;
    private int examineeId;
    private int testId;
    private String date;
    private int totalCorrectAnswer;
    private String testName;
    private Test test;
    private List<ExamineeAnswer> examineeAnswers;
}
