package online_toeic_test_springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuestionGroup {
    private int id;
    private int partId;
    private String audioLink;
    private String paragraph;
    private int difficulty;
}
